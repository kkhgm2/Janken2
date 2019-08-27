import java.util.Scanner;

class Janken{
	String hand;
	int num;
	Janken(int hand){
		if(hand == 1) {
			this.hand = "グー";
			this.num = 1;
		}else if(hand == 2) {
			this.hand = "パー";
			this.num = 2;
		}else {
			this.hand = "チョキ";
			this.num = 3;
		}
	}
	public String getHand() {
		return this.hand;
	}
}

class Battle{
	static int winCount;
	static int loseCount;
	public void battle(Janken my, Janken ene) {
		System.out.println("私は" + my.getHand());
		System.out.println("相手は" + ene.getHand());
		if(my.num == ene.num) {
			System.out.println("あいこです");
		}else if((my.num  == 1 && ene.num == 3) || (my.num  == 2 && ene.num == 1) || (my.num  == 3 && ene.num == 2)){
			System.out.println("私の勝ちだ！  (*ﾟ▽ﾟ)/ﾟ･:*【祝】*:･ﾟ＼(ﾟ▽ﾟ*)");
			winCount++;
		}else {
			System.out.println("お前の負けだ　( `д´)、ﾍﾟｯﾍﾟｯ");
			loseCount++;
		}
	}
	public int getWin() {
		return winCount;
	}
	public int getLose() {
		return loseCount;
	}
}

public class Main {
	public static void main(String[] args) {
		System.out.println("手を入力してください");
		System.out.println("1:グー, 2:パー, 3: チョキ");

		Battle battle = new Battle();
		for(int i = 1; i < 6; i++) {
			//自分の手入力
			int me = new Scanner(System.in).nextInt();
			while(!(me == 1 || me == 2 || me == 3)) {
				System.out.println("1~３ を再度入力してください");
				me = new Scanner(System.in).nextInt();
			}
			//相手の手決定
			int enemy = new java.util.Random().nextInt(4);

			Janken myHand = new Janken(me);
			Janken eneHand = new Janken(enemy);

			battle.battle(myHand, eneHand);
		}
		System.out.println("----------【結　果　発　表】-------------");
		System.out.println("あなたの戦績 : " + battle.getWin() + "勝," +  battle.getLose() + "負");
		if(battle.getWin() > battle.getLose()) {
			System.out.println("おめでとう!!!　ｵﾒ―――ヾ(o'∀｀o)ﾉ");
		}else if(battle.getWin() == battle.getLose()) {
			System.out.println("引き分け、珍しい！！！");
		}else {
			System.out.println(battle.getLose() +"回も負けたの？ ｶｰｯ(ﾟДﾟ≡ﾟдﾟ)､ﾍﾟｯ");
		}
	}
}
