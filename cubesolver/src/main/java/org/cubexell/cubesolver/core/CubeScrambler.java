package org.cubexell.cubesolver.core;

import static org.cubexell.cubesolver.core.CubeConstants.POSSIBLE_MOVES;

public class CubeScrambler {
	private Robot robot;
	public CubeScrambler() {
	}

	public CubeScrambler(Robot robot) {
		this.robot = robot;
	}

	protected String randomScrambleMove() {
		//TODO declare an int called randomIndex and assign to it a random value between 0 and 17
		int randomIndex = ;//TODO assign a random value between 0 and 17 using Math.random(), and casting to int with (int)
		return POSSIBLE_MOVES[randomIndex];
	}

	protected char getFace(String move) {
		//TODO return as a char which face is turned for a given move, i.e. return the first character of the String move
	}

	public String[] getScramble(int numMoves) {
		//TODO generate a random scramble with numMoves moves
		//TODO ensure that no repetition of the turns with the same face, because that could be simplified into one turn





		/*hint: declare and initialize a String array with length numMoves. Then, generate the first random move
		by calling randomScrambleMove(). Next, use a for loop to go through the rest of the moves, but resetting each
		iteration if the face turned by a turn is the same as the previous turn (check using getFace(String move)).
		Finally, return complete sequence of random moves.

		 */
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
