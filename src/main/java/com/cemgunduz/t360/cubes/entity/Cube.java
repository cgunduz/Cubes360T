package com.cemgunduz.t360.cubes.entity;

/**
 * Created by cgunduz on 5/25/14.
 */

// Reverse clockwise as stated and fold in order to make a valid cube
//
//      NORTH
// WEST PIVOT EAST
//      SOUTH
//     PARALEL
public class Cube {

    private int pivotCubeId;

    private int northCubeId;
    private int totalReverseOfNorthCube;

    private int eastCubeId;
    private int totalReverseOfEastCube;

    private int southCubeId;
    private int totalReverseOfSouthCube;

    private int westCubeId;
    private int totalReverseOfWestCube;

    private int parallelCubeId;
    private int totalReverseOfParalelCube;

    public Cube customClone()
    {
        Cube cube = new Cube();
        cube.setPivotCubeId(pivotCubeId);
        cube.setNorthCubeId(northCubeId);
        cube.setEastCubeId(eastCubeId);
        cube.setSouthCubeId(southCubeId);
        cube.setWestCubeId(westCubeId);
        cube.setParallelCubeId(parallelCubeId);
        cube.setTotalReverseOfNorthCube(totalReverseOfNorthCube);
        cube.setTotalReverseOfEastCube(totalReverseOfEastCube);
        cube.setTotalReverseOfSouthCube(totalReverseOfSouthCube);
        cube.setTotalReverseOfWestCube(totalReverseOfWestCube);
        cube.setTotalReverseOfParalelCube(totalReverseOfParalelCube);

        return cube;
    }

    public int getPivotCubeId() {
        return pivotCubeId;
    }

    public void setPivotCubeId(int pivotCubeId) {
        this.pivotCubeId = pivotCubeId;
    }

    public int getNorthCubeId() {
        return northCubeId;
    }

    public void setNorthCubeId(int northCubeId) {
        this.northCubeId = northCubeId;
    }

    public int getTotalReverseOfNorthCube() {
        return totalReverseOfNorthCube;
    }

    public void setTotalReverseOfNorthCube(int totalReverseOfNorthCube) {
        this.totalReverseOfNorthCube = totalReverseOfNorthCube;
    }

    public int getEastCubeId() {
        return eastCubeId;
    }

    public void setEastCubeId(int eastCubeId) {
        this.eastCubeId = eastCubeId;
    }

    public int getTotalReverseOfEastCube() {
        return totalReverseOfEastCube;
    }

    public void setTotalReverseOfEastCube(int totalReverseOfEastCube) {
        this.totalReverseOfEastCube = totalReverseOfEastCube;
    }

    public int getSouthCubeId() {
        return southCubeId;
    }

    public void setSouthCubeId(int southCubeId) {
        this.southCubeId = southCubeId;
    }

    public int getTotalReverseOfSouthCube() {
        return totalReverseOfSouthCube;
    }

    public void setTotalReverseOfSouthCube(int totalReverseOfSouthCube) {
        this.totalReverseOfSouthCube = totalReverseOfSouthCube;
    }

    public int getWestCubeId() {
        return westCubeId;
    }

    public void setWestCubeId(int westCubeId) {
        this.westCubeId = westCubeId;
    }

    public int getTotalReverseOfWestCube() {
        return totalReverseOfWestCube;
    }

    public void setTotalReverseOfWestCube(int totalReverseOfWestCube) {
        this.totalReverseOfWestCube = totalReverseOfWestCube;
    }

    public int getParallelCubeId() {
        return parallelCubeId;
    }

    public void setParallelCubeId(int parallelCubeId) {
        this.parallelCubeId = parallelCubeId;
    }

    public int getTotalReverseOfParalelCube() {
        return totalReverseOfParalelCube;
    }

    public void setTotalReverseOfParalelCube(int totalReverseOfParalelCube) {
        this.totalReverseOfParalelCube = totalReverseOfParalelCube;
    }
}
