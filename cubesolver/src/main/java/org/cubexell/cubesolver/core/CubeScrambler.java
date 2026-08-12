package org.cubexell.cubesolver.core;

import static org.cubexell.cubesolver.core.CubeConstants.*;


public class CubeScrambler {
	private Robot robot;
	public CubeScrambler() {
	}

	public CubeScrambler(Robot robot) {
		this.robot = robot;
	}

	public int getFaceIndex(char face) {
		if (face == 'U') {
			return -1;
		} else if (face == 'D') {
			return 1;
		} else if (face == 'L'){
			return 2;
		} else if (face == 'R'){
			return -2;
		} else if (face == 'F'){
			return 3;
		} else{ // Back
			return -3;
		}
	}

	protected String randomScrambleMove() {
		int randomIndex = (int) (Math.random() * POSSIBLE_MOVES.length);
		return POSSIBLE_MOVES[randomIndex];
	}

	protected char getFace(String move) {
		return move.charAt(0);
	}
	public String[] getScramble(int numMoves) {
		//TODO generate a random scramble with numMoves moves
		//TODO ensure that no repetition of the turns with the same face, because that could be simplified into one turn


		String[] moves = new String[numMoves];
		boolean[] availableFaces = {true, true, true, true, true, true};
		for (int i = 0; i < numMoves; i++) {
			boolean moveAvailable = false;
			String finalMove = "";
			while (moveAvailable) {
				String move = randomScrambleMove();
				char moveFace = getFace(move);
				if (availableFaces[getFaceIndex(moveFace)]) {
					moveAvailable = true;
					boolean opposite_true = availableFaces[-getFaceIndex(moveFace)];
					availableFaces = new boolean[]{true, true, true, true, true, true};
					availableFaces[getFaceIndex(moveFace)] = false;
					availableFaces[-getFaceIndex(moveFace)] = opposite_true;
					finalMove = move;
				}
			}
			moves[i] = finalMove;
		}
		return moves;
	}

	public char[][][] scramble(String[] scrambleMoves){
	    Cube cube = new Cube(Helper.createSolvedCubeColors());
		cube.simulateMoves(scrambleMoves);
		if(robot!=null){
			robot.executeMoves(scrambleMoves);
		}
		return cube.getCubeColors();
	}

	public char[][][] randomScramble(){
	    Cube cube = new Cube(Helper.createSolvedCubeColors());
		String[] scrambleMoves = getScramble(20);
	    cube.simulateMoves(scrambleMoves);
		if(robot!=null){
			robot.executeMoves(scrambleMoves);
		}
		return cube.getCubeColors();
	}
	
}
