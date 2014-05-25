package com.cemgunduz.t360.cubes;

import com.cemgunduz.t360.cubes.entity.Cube;
import com.cemgunduz.t360.cubes.entity.CubePiece;
import com.cemgunduz.t360.cubes.entity.constants.Direction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by cgunduz on 5/25/14.
 */
public class App {

    public static void main(String[] args) throws IOException {

        File file = new File("output.txt");
        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        // BLUE Pieces
        // 0 - 1 - 2
        // 3 - 4 - 5 as given in the input

        // First cube piece of blue cube
        CubePiece blueCubePiece0 = new CubePiece(0,"Blue",
                createDirectionMap(Arrays.asList(Arrays.asList(2), Arrays.asList(2),
                        Arrays.asList(2), Arrays.asList(2))));

        // Second cube piece of blue cube
        CubePiece blueCubePiece1 = new CubePiece(1,"Blue",
                createDirectionMap(Arrays.asList(Arrays.asList(0,2,4), Arrays.asList(0,1,3,4),
                        Arrays.asList(0,2,4), Arrays.asList(0,1,3,4))));

        // Third cube piece of blue cube
        CubePiece blueCubePiece2 = new CubePiece(2,"Blue",
                createDirectionMap(Arrays.asList(Arrays.asList(2), Arrays.asList(1,3),
                        Arrays.asList(2), Arrays.asList(2))));

        // Fourth cube piece of blue cube
        CubePiece blueCubePiece3 = new CubePiece(3,"Blue",
                createDirectionMap(Arrays.asList(Arrays.asList(1,3), Arrays.asList(2),
                        Arrays.asList(0,1,3), Arrays.asList(0,1,3))));

        // Fifth cube piece of blue cube
        CubePiece blueCubePiece4 = new CubePiece(4,"Blue",
                createDirectionMap(Arrays.asList(Arrays.asList(1,3), Arrays.asList(1,3),
                        Arrays.asList(0,2), Arrays.asList(0,1,3))));

        // Sixth cube piece of blue cube
        CubePiece blueCubePiece5 = new CubePiece(5,"Blue",
                createDirectionMap(Arrays.asList(Arrays.asList(1,3), Arrays.asList(1,3,4),
                        Arrays.asList(0,1,3,4), Arrays.asList(0,2))));



        CubeMaker cubeMaker = new CubeMaker();
        cubeMaker.init(Arrays.asList(blueCubePiece0, blueCubePiece1, blueCubePiece2, blueCubePiece3, blueCubePiece4, blueCubePiece5));

        List<Cube> possibleCombinationsList = cubeMaker.giveCubeCombinations();
        writeCombinationsToAFile("Blue", possibleCombinationsList,bw);

        // BLUE Pieces !

        // RED Pieces
        // 0 - 1 - 2
        // 3 - 4 - 5 as given in the input

        // First cube piece of red cube
        CubePiece redCubePiece0 = new CubePiece(0,"Red",
                createDirectionMap(Arrays.asList(Arrays.asList(3,4), Arrays.asList(0,2,4),
                        Arrays.asList(1,2,4), Arrays.asList(2))));

        // Second cube piece of red cube
        CubePiece redCubePiece1 = new CubePiece(1,"Red",
                createDirectionMap(Arrays.asList(Arrays.asList(1,3), Arrays.asList(2),
                        Arrays.asList(1), Arrays.asList(1,3))));

        // Third cube piece of red cube
        CubePiece redCubePiece2 = new CubePiece(2,"Red",
                createDirectionMap(Arrays.asList(Arrays.asList(1,2,4), Arrays.asList(0,1,3,4),
                        Arrays.asList(0,3,4), Arrays.asList(0,1,3))));

        // Fourth cube piece of red cube
        CubePiece redCubePiece3 = new CubePiece(3,"Red",
                createDirectionMap(Arrays.asList(Arrays.asList(2), Arrays.asList(2),
                        Arrays.asList(2), Arrays.asList(1,3))));

        // Fifth cube piece of red cube
        CubePiece redCubePiece4 = new CubePiece(4,"Red",
                createDirectionMap(Arrays.asList(Arrays.asList(2,3), Arrays.asList(1,3),
                        Arrays.asList(0,2), Arrays.asList(0,1,3))));

        // Sixth cube piece of red cube
        CubePiece redCubePiece5 = new CubePiece(5,"Red",
                createDirectionMap(Arrays.asList(Arrays.asList(1,2), Arrays.asList(0,2),
                        Arrays.asList(0,1,3,4), Arrays.asList(0,2))));



        CubeMaker cubeMakerForRed = new CubeMaker();
        cubeMakerForRed.init(Arrays.asList(redCubePiece0, redCubePiece1, redCubePiece2, redCubePiece3, redCubePiece4, redCubePiece5));

        List<Cube> possibleCombinationsListForRed = cubeMakerForRed.giveCubeCombinations();
        writeCombinationsToAFile("Red", possibleCombinationsListForRed ,bw);

        // RED Pieces !

        // PURPLE Pieces
        // 0 - 1 - 2
        // 3 - 4 - 5 as given in the input

        // First cube piece of purple cube
        CubePiece purpleCubePiece0 = new CubePiece(0,"Purple",
                createDirectionMap(Arrays.asList(Arrays.asList(3,4), Arrays.asList(0,2,4),
                        Arrays.asList(1,2,4), Arrays.asList(2))));

        // Second cube piece of purple cube
        CubePiece purpleCubePiece1 = new CubePiece(1,"Purple",
                createDirectionMap(Arrays.asList(Arrays.asList(1,3), Arrays.asList(2),
                        Arrays.asList(1), Arrays.asList(1,3))));

        // Third cube piece of purple cube
        CubePiece purpleCubePiece2 = new CubePiece(2,"Purple",
                createDirectionMap(Arrays.asList(Arrays.asList(1,2,4), Arrays.asList(0,1,3,4),
                        Arrays.asList(0,3,4), Arrays.asList(0,1,3))));

        // Fourth cube piece of purple cube
        CubePiece purpleCubePiece3 = new CubePiece(3,"Purple",
                createDirectionMap(Arrays.asList(Arrays.asList(2), Arrays.asList(2),
                        Arrays.asList(2), Arrays.asList(1,3))));

        // Fifth cube piece of purple cube
        CubePiece purpleCubePiece4 = new CubePiece(4,"Purple",
                createDirectionMap(Arrays.asList(Arrays.asList(2,4), Arrays.asList(1,3),
                        Arrays.asList(0,2), Arrays.asList(0,1,3))));

        // Sixth cube piece of purple cube
        CubePiece purpleCubePiece5 = new CubePiece(5,"Purple",
                createDirectionMap(Arrays.asList(Arrays.asList(1,2), Arrays.asList(0,2),
                        Arrays.asList(0,1,3,4), Arrays.asList(0,2))));



        CubeMaker cubeMakerForPurple = new CubeMaker();
        cubeMakerForPurple.init(Arrays.asList(purpleCubePiece0, purpleCubePiece1, purpleCubePiece2, purpleCubePiece3, purpleCubePiece4, purpleCubePiece5));

        List<Cube> possibleCombinationsListForPurple = cubeMakerForPurple.giveCubeCombinations();
        writeCombinationsToAFile("Purple", possibleCombinationsListForPurple ,bw);

        // PURPLE Pieces !

        // YELLOW Pieces
        // 0 - 1 - 2
        // 3 - 4 - 5 as given in the input

        // First cube piece of purple cube
        CubePiece yellowCubePiece0 = new CubePiece(0,"Yellow",
                createDirectionMap(Arrays.asList(Arrays.asList(2), Arrays.asList(2),
                        Arrays.asList(1,3), Arrays.asList(1,3))));

        // Second cube piece of purple cube
        CubePiece yellowCubePiece1 = new CubePiece(1,"Yellow",
                createDirectionMap(Arrays.asList(Arrays.asList(2,4), Arrays.asList(3,4),
                        Arrays.asList(1,3), Arrays.asList(1,3))));

        // Third cube piece of purple cube
        CubePiece yellowCubePiece2 = new CubePiece(2,"Yellow",
                createDirectionMap(Arrays.asList(Arrays.asList(2,4), Arrays.asList(1,3,4),
                        Arrays.asList(0,2), Arrays.asList(0,1,2))));

        // Fourth cube piece of purple cube
        CubePiece yellowCubePiece3 = new CubePiece(3,"Yellow",
                createDirectionMap(Arrays.asList(Arrays.asList(0,2,4), Arrays.asList(1,3,4),
                        Arrays.asList(0,2), Arrays.asList(0,1,3,4))));

        // Fifth cube piece of purple cube
        CubePiece yellowCubePiece4 = new CubePiece(4,"Yellow",
                createDirectionMap(Arrays.asList(Arrays.asList(2), Arrays.asList(1,3),
                        Arrays.asList(0,1,3), Arrays.asList(0,2))));

        // Sixth cube piece of purple cube
        CubePiece yellowCubePiece5 = new CubePiece(5,"Yellow",
                createDirectionMap(Arrays.asList(Arrays.asList(1,3), Arrays.asList(0,2),
                        Arrays.asList(1,3,4), Arrays.asList(2))));



        CubeMaker cubeMakerForYellow = new CubeMaker();
        cubeMakerForYellow.init(Arrays.asList(yellowCubePiece0, yellowCubePiece1, yellowCubePiece2, yellowCubePiece3, yellowCubePiece4, yellowCubePiece5));

        List<Cube> possibleCombinationsListForYellow = cubeMakerForYellow.giveCubeCombinations();
        writeCombinationsToAFile("Yellow", possibleCombinationsListForYellow ,bw);

        // YELLOW Pieces !

        bw.close();
    }

    // Just for hardcoding the maps in the picture
    private static Boolean[] createPieceMapOf5(List<Integer> locationList)
    {
        Boolean[] booleans = new Boolean[5];
        for(int i = 0; i < 5 ; i++)
        {
            if(locationList.contains(i))
                booleans[i] = true;
            else
                booleans[i] = false;
        }

        return booleans;
    }

    // Just fot hardcoding layers in the picture
    // Each array is one direction starts from North -> East -> South -> West as defined in directions enum
    private static Map<Direction, Boolean[]> createDirectionMap(List<List<Integer>> listOfIntegerList)
    {
        Map<Direction, Boolean[]> directionMap = new HashMap<Direction, Boolean[]>();
        directionMap.put(Direction.NORTH, createPieceMapOf5(listOfIntegerList.get(0)));
        directionMap.put(Direction.EAST, createPieceMapOf5(listOfIntegerList.get(1)));
        directionMap.put(Direction.SOUTH, createPieceMapOf5(listOfIntegerList.get(2)));
        directionMap.put(Direction.WEST, createPieceMapOf5(listOfIntegerList.get(3)));

        return directionMap;
    }

    private static void writeCombinationsToAFile(String color, List<Cube> possibleCombinationsList, BufferedWriter bw) throws IOException {

        bw.write("------------------\n\n");
        bw.write("Color of pieces : " + color + "\n\n");
        bw.write("Total alternatives : " + possibleCombinationsList.size() + "\n\n");

        int alternativeNo = 1;
        for(Cube cube : possibleCombinationsList)
        {
            bw.write("Cube alternative " + alternativeNo + " : \n");
            bw.write("    " + cube.getNorthCubeId() + "(" + cube.getTotalReverseOfNorthCube() +")" + "\n");
            bw.write(cube.getWestCubeId() + "(" + cube.getTotalReverseOfWestCube() +")");
            bw.write(cube.getPivotCubeId() + "(0)");
            bw.write(cube.getEastCubeId() + "(" + cube.getTotalReverseOfEastCube() +")\n");
            bw.write("    " + cube.getSouthCubeId() + "(" + cube.getTotalReverseOfSouthCube() +")" + "\n");
            bw.write("    " + cube.getParallelCubeId() + "(" + cube.getTotalReverseOfParalelCube() +")" + "\n");
            bw.write("------------------\n\n");

            alternativeNo++;
        }

        bw.write("------------------\n\n");
    }
}
