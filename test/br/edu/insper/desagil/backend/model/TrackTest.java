package br.edu.insper.desagil.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackTest {
	private Artist artista;

	@BeforeEach
	void setUp() {
		artista = new Artist("Hashi");
	}

	@Test
	void testZeroSeconds() {
		Track track = new Track(artista, "Desagil", 0 );
		String duracao = track.getDurationString();
		assertEquals("0:00", duracao);
	}

	@Test
	void testFiveSeconds() {
		Track track = new Track(artista, "Desagil", 5 );
		String duracao = track.getDurationString();
		assertEquals("0:05", duracao);
	}

	@Test
	void testTwentyFiveSeconds() {
		Track track = new Track(artista, "Desagil", 25 );
		String duracao = track.getDurationString();
		assertEquals("0:25", duracao);
	}

	@Test
	void testOneMinuteZeroSeconds() {
		Track track = new Track(artista, "Desagil", 60 );
		String duracao = track.getDurationString();
		assertEquals("1:00", duracao);
	}

	@Test
	void testOneMinuteFiveSeconds() {
		Track track = new Track(artista, "Desagil", 65 );
		String duracao = track.getDurationString();
		assertEquals("1:05", duracao);
	}

	@Test
	void testOneMinuteTwentyFiveSeconds() {
		Track track = new Track(artista, "Desagil", 85 );
		String duracao = track.getDurationString();
		assertEquals("1:25", duracao);
	}

	@Test
	void testTwoMinutesZeroSeconds() {
		Track track = new Track(artista, "Desagil", 120 );
		String duracao = track.getDurationString();
		assertEquals("2:00", duracao);
	}

	@Test
	void testTwoMinutesFiveSeconds() {
		Track track = new Track(artista, "Desagil", 125 );
		String duracao = track.getDurationString();
		assertEquals("2:05", duracao);
	}

	@Test
	void testTwoMinutesTwentyFiveSeconds() {
		Track track = new Track(artista, "Desagil", 145);
		String duracao = track.getDurationString();
		assertEquals("2:25", duracao);
	}

	@Test
	void testOneCollaborator() {
		Artist artista1 = new Artist("Anitta");
		Artist artista2 = new Artist("Becky G");
		List<Artist> colaborador = new ArrayList<>();
		colaborador.add(artista2);
		CollaborationTrack colaboracao = new CollaborationTrack(artista1,colaborador,"Hello", 120);
		assertEquals("Anitta (feat. Becky G)", colaboracao.getFullArtistName());
	}

	@Test
	void testTwoCollaborators() {
		Artist artista1 = new Artist("Anitta");
		Artist artista2 = new Artist("Ludmilla");
		Artist artista3 = new Artist("Snoop Dog");
		List<Artist> colaborador = new ArrayList<>();
		colaborador.add(artista2);
		colaborador.add(artista3);
		CollaborationTrack colaboracao = new CollaborationTrack(artista1,colaborador,"Hello", 120);
		assertEquals("Anitta (feat. Ludmilla, Snoop Dog)", colaboracao.getFullArtistName());
	}
}
