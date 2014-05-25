package com.cemgunduz.t360.cubes.entity.constants;

/**
 * Created by cgunduz on 5/25/14.
 */
public enum Direction {

    NORTH(3), EAST(2), SOUTH(1), WEST(0);

    // Needed at cube maker -> getClockwiseRotationNeededToConnectToPivot
    private int clockwiseRotationDistanceFromEast;

    private Direction(int rotation)
    {
        this.clockwiseRotationDistanceFromEast = rotation;
    }

    public int getClockwiseRotationDistanceFromEast() {
        return clockwiseRotationDistanceFromEast;
    }

    public static Direction rotate(Direction direction, int rotateAmount)
    {
        return Direction.values()[Math.abs(direction.getClockwiseRotationDistanceFromEast() - (rotateAmount % 4))];
    }
}
