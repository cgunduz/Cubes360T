package com.cemgunduz.t360.cubes.entity;

import com.cemgunduz.t360.cubes.entity.constants.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created by cgunduz on 5/25/14.
 */

/*
 * Every cube piece is a 5 x 5 square
 * The inner 3 x 3 square is always fixed so I will only hold the outer layer of 5 x 4 the 5 points for each direction
*/
public class CubePiece {

    // id ish
    // will continue on respecting the model :
    // 1 2 3
    //   4
    //   5
    //   6
    private int cubeNo;

    // Just to be clear when mapping cubes
    private String color;

    // The point zero is either the left side or the bottom side, consider left bottom as 0,0
    private Map<Direction, Boolean[]> outerLayerMap = new HashMap<Direction, Boolean[]>();

    /* TODO : CLEAR ?
    // Each cube piece knows whether a face of it is mathcing or not with another cube's face ( of same color )
    private Map<CubePieceConnection, Boolean> matchMap = new HashMap<CubePieceConnection, Boolean>();
    */

    // Each cube also knows for each of its directions, which cube number & direction is a valid match for it
    private Map<Direction, List<CubePieceConnection>> directionalMatchMap = new HashMap<Direction, List<CubePieceConnection>>();

    private int totalMatches = 0;

    public CubePiece(int cubeNo, String color, Map<Direction, Boolean[]> outerLayerMap) {
        this.cubeNo = cubeNo;
        this.color = color;
        this.outerLayerMap = outerLayerMap;

        // Initializing directionalMatchMap
        for(Direction direction : Direction.values())
            directionalMatchMap.put(direction, new ArrayList<CubePieceConnection>());
    }

    public int getCubeNo() {
        return cubeNo;
    }

    public String getColor() {
        return color;
    }

    public Map<Direction, Boolean[]> getOuterLayerMap() {
        return outerLayerMap;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void incrementTotalMatches() {
        this.totalMatches++;
    }

    /* TODO : CLEAR ?
    public Map<CubePieceConnection, Boolean> getMatchMap() {
        return matchMap;
    }
    */

    public Map<Direction, List<CubePieceConnection>> getDirectionalMatchMap() {
        return directionalMatchMap;
    }

    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof CubePiece))
            return false;

        CubePiece obj = (CubePiece)o;
        return obj.getCubeNo() == this.getCubeNo() && obj.getColor().equals(this.getColor());
    }

    @Override
    public int hashCode() {
        int result = cubeNo;
        result = 31 * result + color.hashCode();
        return result;
    }

    /* TODO : CLEAR ?
    public boolean containsAMatchFor(Direction self, Direction neighbour, int neighbourNo)
    {
        CubePieceConnection cubePieceFace = new CubePieceConnection(neighbourNo,self,neighbour);
        return getMatchMap().get(cubePieceFace);
    }
    */

    public boolean containsAMatchFor(Direction self, Direction neighbour, int neighbourNo)
    {
        CubePieceConnection cubePieceConnection = new CubePieceConnection(neighbourNo,self,neighbour);
        return getDirectionalMatchMap().get(self).contains(cubePieceConnection);
    }
}
