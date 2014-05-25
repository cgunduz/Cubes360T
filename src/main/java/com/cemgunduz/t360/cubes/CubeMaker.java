package com.cemgunduz.t360.cubes;

import com.cemgunduz.t360.cubes.entity.Cube;
import com.cemgunduz.t360.cubes.entity.CubePiece;
import com.cemgunduz.t360.cubes.entity.CubePieceConnection;
import com.cemgunduz.t360.cubes.entity.constants.Direction;

import java.util.*;

/**
 * Created by cgunduz on 5/25/14.
 */
public class CubeMaker {

    // Has always six pieces
    CubePiece[] cubePieces;

    // Prepares the cube pieces, introduces each piece to the other
    // Required for later calculations
    public void init(List<CubePiece> cubePieceList)
    {
        if(cubePieceList.size() != 6)
            throw new IllegalArgumentException("A cube has to have 6 faces");

        // Init map for each cube piece
        // In other words each piece knows which other piece they fit into
        cubePieces = cubePieceList.toArray(new CubePiece[6]);

        for(CubePiece cubePiece : cubePieces)
        {
            for(CubePiece cubePieceOpp : cubePieces)
            {
                // If they are the same cubes pass
                if(cubePiece.equals(cubePieceOpp))
                    continue;

                for(Direction direction1 : Direction.values())
                {
                    for(Direction direction2 : Direction.values())
                    {
                        CubePieceConnection cubePieceConnection = new CubePieceConnection(cubePieceOpp.getCubeNo(), direction1, direction2);
                        boolean layersMatch = layersMatch(cubePiece.getOuterLayerMap().get(direction1), cubePieceOpp.getOuterLayerMap().get(direction2));
                        /* TODO : CLEAR ?
                        cubePiece.getMatchMap().put(cubePieceConnection, layersMatch);
                        */

                        if(layersMatch)
                        {
                            // Increment total matches later on to decide which cube piece to use as a pivot
                            cubePiece.incrementTotalMatches();

                            // Record all matches
                            cubePiece.getDirectionalMatchMap().get(direction1).add(cubePieceConnection);
                        }
                    }
                }
            }
        }
    }

    public void printCubePiecesMatchAmounts()
    {
        for(CubePiece cubePiece : cubePieces)
            System.out.println(cubePiece.getTotalMatches());
    }

    public boolean hasAMatch(int cube1, int cube2, Direction cube1Direction, Direction cube2Direction)
    {
        return cubePieces[cube1].containsAMatchFor(cube1Direction, cube2Direction, cube2);
    }

    // Returns the answers in the form :
    // 0 1 2
    //   3
    //   4
    //   5
    // Or in other words
    // 1 -> Pivot , 0 -> WEST, 2 -> EAST, 3 -> SOUTH, 5 -> NORTH, 4 -> Paralel
    public List<Cube> giveCubeCombinations()
    {
        // Create solution on top of the cube piece with the minimum possible matches
        // for best performance
        int pivot = choosePivot();

        // Result
        List<Cube> combinations = new ArrayList<Cube>();

        // Base cube
        Cube cube = new Cube();
        cube.setPivotCubeId(pivot);

        // Base exclusion set
        List<Integer> exculusionSet = new ArrayList<Integer>();
        exculusionSet.add(pivot);

        // TODO : Clean boilerplate if you have time
        // Try every option in the pivot's possibility tree
        for(CubePieceConnection cubePieceConnectionNorth : cubePieces[pivot].getDirectionalMatchMap().get(Direction.NORTH))
        {
            int rotationNeededForNorth = getClockwiseRotationNeededToConnectToPivot(Direction.NORTH, cubePieceConnectionNorth.getDirection2());

            Cube candidateCubeOfNorth = cube.customClone();
            candidateCubeOfNorth.setNorthCubeId(cubePieceConnectionNorth.getCubeNo());
            candidateCubeOfNorth.setTotalReverseOfNorthCube(rotationNeededForNorth);
            exculusionSet.add(cubePieceConnectionNorth.getCubeNo());

            for(CubePieceConnection cubePieceConnectionEast : cubePieces[pivot].getDirectionalMatchMap().get(Direction.EAST))
            {
                int rotationNeededForEast = getClockwiseRotationNeededToConnectToPivot(Direction.EAST, cubePieceConnectionEast.getDirection2());

                if(exculusionSet.contains(cubePieceConnectionEast.getCubeNo()) ||
                        !hasAMatch(cubePieceConnectionNorth.getCubeNo(), cubePieceConnectionEast.getCubeNo(),
                                Direction.rotate(Direction.EAST, rotationNeededForNorth), Direction.rotate(Direction.NORTH, rotationNeededForEast)))
                    continue;

                Cube candidateCubeOfEast = candidateCubeOfNorth.customClone();
                candidateCubeOfEast.setEastCubeId(cubePieceConnectionEast.getCubeNo());
                candidateCubeOfEast.setTotalReverseOfEastCube(rotationNeededForEast);
                exculusionSet.add(cubePieceConnectionEast.getCubeNo());

                for(CubePieceConnection cubePieceConnectionSouth : cubePieces[pivot].getDirectionalMatchMap().get(Direction.SOUTH))
                {
                    int rotationNeededForSouth = getClockwiseRotationNeededToConnectToPivot(Direction.SOUTH, cubePieceConnectionSouth.getDirection2());

                    if(exculusionSet.contains(cubePieceConnectionSouth.getCubeNo()) ||
                            !hasAMatch(cubePieceConnectionEast.getCubeNo(), cubePieceConnectionSouth.getCubeNo(),
                                    Direction.rotate(Direction.SOUTH, rotationNeededForNorth), Direction.rotate(Direction.EAST, rotationNeededForEast)))
                        continue;

                    Cube candidateCubeOfSouth = candidateCubeOfEast.customClone();
                    candidateCubeOfSouth.setSouthCubeId(cubePieceConnectionSouth.getCubeNo());
                    candidateCubeOfSouth.setTotalReverseOfSouthCube(rotationNeededForSouth);
                    exculusionSet.add(cubePieceConnectionSouth.getCubeNo());

                    for(CubePieceConnection cubePieceConnectionWest : cubePieces[pivot].getDirectionalMatchMap().get(Direction.WEST))
                    {
                        int rotationNeededForWest = getClockwiseRotationNeededToConnectToPivot(Direction.WEST, cubePieceConnectionWest.getDirection2());

                        if(exculusionSet.contains(cubePieceConnectionWest.getCubeNo())||
                                !hasAMatch(cubePieceConnectionSouth.getCubeNo(), cubePieceConnectionWest.getCubeNo(),
                                        Direction.rotate(Direction.WEST, rotationNeededForSouth), Direction.rotate(Direction.SOUTH, rotationNeededForWest))
                                ||
                                !hasAMatch(cubePieceConnectionWest.getCubeNo(), cubePieceConnectionNorth.getCubeNo(),
                                        Direction.rotate(Direction.NORTH, rotationNeededForWest), Direction.rotate(Direction.WEST, rotationNeededForNorth)))
                            continue;

                        Cube candidateCubeOfWest = candidateCubeOfSouth.customClone();
                        candidateCubeOfWest.setWestCubeId(cubePieceConnectionWest.getCubeNo());
                        candidateCubeOfWest.setTotalReverseOfWestCube(rotationNeededForWest);
                        exculusionSet.add(cubePieceConnectionWest.getCubeNo());

                        // Get last cube piece
                        int lastCubePieceNo = getTopLayer(exculusionSet);

                        // Rotate top layer 4 times and see if it fits
                        for(int rotateFor = 0; rotateFor < 4; rotateFor++)
                        {
                            if(hasAMatch(lastCubePieceNo, cubePieceConnectionNorth.getCubeNo(), Direction.rotate(Direction.NORTH, rotateFor),                                    Direction.rotate(cubePieceConnectionNorth.getDirection2(), 2)))
                            {
                                if(hasAMatch(lastCubePieceNo, cubePieceConnectionEast.getCubeNo(), Direction.rotate(Direction.EAST, rotateFor),
                                        Direction.rotate(cubePieceConnectionEast.getDirection2(), 2)))
                                {
                                    if(hasAMatch(lastCubePieceNo, cubePieceConnectionSouth.getCubeNo(), Direction.rotate(Direction.SOUTH, rotateFor),
                                            Direction.rotate(cubePieceConnectionSouth.getDirection2(), 2)))
                                    {
                                        if(hasAMatch(lastCubePieceNo, cubePieceConnectionEast.getCubeNo(), Direction.rotate(Direction.EAST, rotateFor),
                                                Direction.rotate(cubePieceConnectionEast.getDirection2(), 2)))
                                        {
                                            // Finally this satisfies everything =)
                                            Cube acceptedCube = candidateCubeOfWest.customClone();
                                            acceptedCube.setParallelCubeId(lastCubePieceNo);
                                            acceptedCube.setTotalReverseOfParalelCube(rotateFor);

                                            combinations.add(acceptedCube);
                                        }
                                    }
                                }
                            }
                        }
                        // remove last
                        exculusionSet.remove(exculusionSet.size()-1);
                    }
                    exculusionSet.remove(exculusionSet.size()-1);
                }
                exculusionSet.remove(exculusionSet.size()-1);
            }
            exculusionSet.remove(exculusionSet.size()-1);
        }

        return combinations;
    }


    // If there is a piece on both layers they will co incide that would be a mismatch
    // otherwise it should be considered as a match
    private boolean layersMatch(Boolean[] layer1, Boolean[] layer2)
    {
        for(int i = 0; i < 5; i++)
            if(layer1[i] == true && layer2[i] == true)
                return false;

        return true;
    }

    // Find the cube with the minimum amount of matches
    private int choosePivot()
    {
        int pivot = 0;
        int min = cubePieces[0].getTotalMatches();
        for(int i = 1; i < 5; i ++)
            if(min > cubePieces[i].getTotalMatches())
            {
                min = cubePieces[i].getTotalMatches();
                pivot = i;
            }

        return pivot;
    }

    // Calculates how many times a cube piece have to rotate clockwise in order to fit to a static cube piece
    private int getClockwiseRotationNeededToConnectToPivot(Direction connectionPointOfPivot, Direction connectionPointOfPiece)
    {
        return Math.abs(connectionPointOfPivot.getClockwiseRotationDistanceFromEast() -
                connectionPointOfPiece.getClockwiseRotationDistanceFromEast() - 2);
    }

    // Returns the only layer that is not within the exclusion set
    private int getTopLayer(List<Integer> exclusionSet)
    {
        for(int i = 0; i < 6; i++)
            if(!exclusionSet.contains(i))
                return i;

        return -1;
    }

}
