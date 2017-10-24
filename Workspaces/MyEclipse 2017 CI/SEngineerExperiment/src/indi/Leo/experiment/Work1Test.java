package indi.Leo.experiment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sun.net.www.content.audio.wav;

public class Work1Test {
	private static Work1 w = new Work1();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		w.setName("Leo");
		assertEquals("Leo", w.getName());
	}

	@Test
	public void testSetName() {
		w.setName("Jobs");
		assertEquals("Jobs", w.getName());
	}

	@Test
	public void testGetFriend() {
		w.setFriend("Steve");
		assertEquals("Steve", w.getFriend());
	}

	@Test
	public void testSetFriend() {
		w.setFriend("Leopard");
		assertEquals("Leopard", w.getFriend());
	}

}
