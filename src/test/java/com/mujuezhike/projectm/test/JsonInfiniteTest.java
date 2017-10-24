package com.mujuezhike.projectm.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsonInfiniteTest {
	
	public static void main(String[] args) {
		
		Beane b1 = new Beane();
		b1.setNe("b1");
		Beane b2 = new Beane();
		b2.setNe("b2");
		Beane b3 = new Beane();
		b3.setNe("b3");
		b1.setC(b2);
		b2.setC(b3);
		b3.setC(b1);
		Beane b4 = new Beane();
		b3.setNe("b4");
		b4.setC(b2);
		
		List<Beane> listb1 = new ArrayList<Beane>();
		listb1.add(b1);
		listb1.add(b2);
		listb1.add(b3);
		listb1.add(b4);
		b1.setList(listb1);
		
		
		String m = JSON.toJSONString(b4);
		System.out.println(m);
		
	}

}

class Beane {
	
	private Beane c;
	
	private String ne;
	
	private List<Beane> list;

	public Beane getC() {
		return c;
	}

	public void setC(Beane c) {
		this.c = c;
	}

	public String getNe() {
		return ne;
	}

	public void setNe(String ne) {
		this.ne = ne;
	}

	public List<Beane> getList() {
		return list;
	}

	public void setList(List<Beane> list) {
		this.list = list;
	}
}
