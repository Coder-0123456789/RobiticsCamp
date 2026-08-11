package org.cubexell.cubesolver.core;

import static org.cubexell.cubesolver.core.CubeConstants.POSSIBLE_MOVES;
import static org.cubexell.cubesolver.core.CubeConstants.POSSIBLE_MOVES;


public class CubeScrambler {
	private Robot robot;
	public CubeScrambler() {
	}

	public CubeScrambler(Robot robot) {
		this.robot = robot;
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
			boolean = moveAvailable;
			while moveAvailable {
				
			}
		}



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
