package br.edu.insper.desagil.backend.model;

public class Track {
	private Artist artist;
	private String name;
	private Integer duration;
	
	public Track(Artist artist, String name, Integer duration) {
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}

	public Artist getArtist() {
		return artist;
	}

	public String getName() {
		return name;
	}

	public Integer getDuration() {
		return duration;
	}
	
	public String getDurationString() {
		Integer segundos = this.duration;
		Integer minutos = segundos/60;
		Integer segundosRestantes = segundos % 60;
		String segundosRestantes2;
		if (segundosRestantes < 10) {
			segundosRestantes2 = 0+Integer.toString(segundosRestantes);
		} else {
			segundosRestantes2 = Integer.toString(segundosRestantes);
		}
		String duracao = Integer.toString(minutos)+":"+segundosRestantes2;
		return duracao;
	}
	
	public String getFullArtistName() {
		return getArtist().getName();
	}

	
}
