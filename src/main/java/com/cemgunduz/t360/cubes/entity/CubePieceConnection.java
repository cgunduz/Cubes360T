package com.cemgunduz.t360.cubes.entity;

import com.cemgunduz.t360.cubes.entity.constants.Direction;

/**
 * Created by cgunduz on 5/25/14.
 *
 */
// One face of a single cube piece
public class CubePieceConnection {

    // The cube and the face it is connected with
    int cubeNo;
    Direction direction2;

    // Optional self - reference, the place it is connected to self from, a connection should reside inside a piece
    Direction direction1;


    public CubePieceConnection(int cubeNo, Direction direction1, Direction direction2) {
        this.cubeNo = cubeNo;
        this.direction1 = direction1;
        this.direction2 = direction2;
    }

    public int getCubeNo() {
        return cubeNo;
    }

    public void setCubeNo(int cubeNo) {
        this.cubeNo = cubeNo;
    }

    public Direction getDirection1() {
        return direction1;
    }

    public void setDirection1(Direction direction1) {
        this.direction1 = direction1;
    }

    public Direction getDirection2() {
        return direction2;
    }

    public void setDirection2(Direction direction2) {
        this.direction2 = direction2;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof CubePieceConnection))
            return false;

        CubePieceConnection cubePieceConnection = (CubePieceConnection)obj;

        return cubePieceConnection.getCubeNo() == cubeNo && cubePieceConnection.getDirection1() == direction1
                && cubePieceConnection.getDirection2() == direction2;
    }

    @Override
    public int hashCode() {
        int result = cubeNo;
        result = 31 * result + direction1.hashCode();
        result = 31 * result + direction2.hashCode();
        return result;
    }
}
