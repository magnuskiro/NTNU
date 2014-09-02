package game;


@SuppressWarnings("unchecked")
public class Score implements Comparable {
	private final int time = 0, ghost = 1, score = 2, scoreSort;
	private int level, timeUsed, ghostsUsed, myScore, sortAfter;
	private int[] sortArray;
	private String playerName;
	
	Score(int timeUsed, int ghostsUsed, String playerName, int level){
		this.timeUsed = timeUsed;
		this.ghostsUsed = ghostsUsed;
		this.playerName = playerName;
		this.level = level;
		this.myScore = calculateScore();
		scoreSort = (100000 - this.myScore);
		int[] tempArray = {this.timeUsed, this.ghostsUsed, this.scoreSort};
		this.sortArray = tempArray;
		this.sortAfter = this.score; //sorterer automatisk etter scoren som er oppn�dd
	}
	@Override
	public int compareTo(Object otherScore) {
		int compareScore = ((Score) otherScore).getSortArray(this.sortAfter);
		if( compareScore == this.sortArray[this.sortAfter]){
			return 0;
		} else if (compareScore < this.sortArray[this.sortAfter]){
			return 1;
		} else {
			return -1;
		}
	}
	
	public int getSortArray(int index){
		return sortArray[index];
	}
	
	public void  setSortAfter(int sortAfter){
		switch(sortAfter){
		case time: this.sortAfter = this.time; break;
		case ghost: this.sortAfter = this.ghost; break;
		case score: this.sortAfter = this.score; break;
		}
	}
	
	
	public int calculateScore(){
		int result = (int) (10000/(this.ghostsUsed + this.timeUsed));
		return result;
	}
	
	public String toString(){
		return (this.timeUsed + " " + this.ghostsUsed + " " + this.playerName + " " + this.level);
	}

	public int getLevel() {
		return level;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getTimeUsed() {
		return timeUsed;
	}

	public int getGhostsUsed() {
		return ghostsUsed;
	}

	public int getScore() {
		return myScore;
	}
}
