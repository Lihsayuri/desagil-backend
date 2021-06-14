package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaylistTest {
	private static double DELTA = 0.000001;
	private Playlist playlist;
	private Track faixa; 
	private Artist artista;

	@BeforeEach
	void setUp() {
		playlist = new Playlist(0);
		artista = new Artist("Hashi");
		faixa = new Track(artista, "Hallo", 120);
	}

	@Test
	void testRoundDownToZero() {
		playlist.addTrack(faixa);
		playlist.putRating("Rita", 1);
		playlist.putRating("Mario", 2);
		playlist.putRating("Henrique", 3);
		playlist.putRating("Bernardo", 3);
		assertEquals(2.0, playlist.averageRatings());
	}

	@Test
	void testRoundUpToHalf() {
		playlist.addTrack(faixa);
		playlist.putRating("Rita", 1);
		playlist.putRating("Mario", 2);
		playlist.putRating("Henrique", 1);
		assertEquals(1.5, playlist.averageRatings());
	}

	@Test
	void testRoundDownToHalf() {
		playlist.addTrack(faixa);
		playlist.putRating("Rita", 1);
		playlist.putRating("Mario", 2);
		playlist.putRating("Henrique", 2);
		assertEquals(1.5, playlist.averageRatings());
	}

	@Test
	void testRoundUpToOne() {
		playlist.addTrack(faixa);
		playlist.putRating("Rita", 1);
		playlist.putRating("Mario", 1);
		playlist.putRating("Henrique", 2);
		playlist.putRating("Bernardo", 3);
		assertEquals(2.0, playlist.averageRatings());
	}
}
