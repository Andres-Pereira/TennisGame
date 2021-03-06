public class TennisGame2 implements TennisGame
{
    public int P1_Points = 0;
    public int P2_Points = 0;
    
    private String player1Name;
    private String player2Name;
    String score="";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
    	if(isNormal())
    		score=getLiteral(P1_Points)+"-"+getLiteral(P2_Points);
    	if(isTie())
    		score=getLiteral(P1_Points)+"-"+"All";
    	if(isDeuce())
    		score="Deuce";
    	score= advantage(score);
    	score= win(score);
        return score;
    }

	private String advantage(String score) {
		if (P1_Points > P2_Points && P2_Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2_Points > P1_Points && P1_Points >= 3)
        {
            score = "Advantage player2";
        }
		return score;
	}

	private String win(String score) {
		if (P1_Points>=4 && P2_Points>=0 && (P1_Points-P2_Points)>=2)
        {
            score = "Win for player1";
        }
        if (P2_Points>=4 && P1_Points>=0 && (P2_Points-P1_Points)>=2)
        {
            score = "Win for player2";
        }
		return score;
	}


	private boolean isNormal() 
	{
		return P2_Points!=P1_Points;
	}

	private String getLiteral(int p1point2) {
		String result = "";
		if (p1point2==0)
			result = "Love";
		if (p1point2==1)
			result = "Fifteen";
		if (p1point2==2)
			result = "Thirty";
		if (p1point2==3)
			result = "Forty";
		return result;
	}

	private boolean isTie() {
		return P1_Points==P2_Points && P1_Points<4;
	}

	private boolean isDeuce() {
		return P1_Points==P2_Points&& P1_Points>=3;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1_Points++;
    }
    
    public void P2Score(){
        P2_Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}