package kr.human.java0427;

class RepairableTest{
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();

		Marine marine = new Marine();
		SCV	scv = new SCV();

		scv.repair(tank);	// SCV�� Tank�� �����ϵ��� �Ѵ�.
		scv.repair(dropship);
//		scv.repair(marine);	
	}
}

// 아무 내용이 없는 인터페이스 : 표시인터페이스라고 한다. 무엇이 가능하냐라는 표시를 달떄 사용
interface Repairable {}

class Unit {
	int hitPoint;
	final int MAX_HP;
	Unit(int hp) {
		MAX_HP = hp;
	}
	//...
}

class GroundUnit extends Unit {
	GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}



class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);		// Tank�� HP�� 150�̴�.
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}
	//...
}

class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125);		// Dropship�� HP�� 125�̴�.
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Dropship";
	}
	//...
}

class Marine extends GroundUnit {
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
	//...
}

class SCV extends GroundUnit implements Repairable{
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) { // 인수의 타입이 인터페이스다.
		if (r instanceof Unit) {
			Unit u = (Unit)r;
			while(u.hitPoint!=u.MAX_HP) {
				/* Unit�� HP�� ������Ų��. */
				u.hitPoint++;
			}
			System.out.println( u.toString() + "을(를) 수리합니다.");
		}
	}	
	//...
}
