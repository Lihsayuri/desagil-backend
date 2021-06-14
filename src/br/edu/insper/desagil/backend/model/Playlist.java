package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
	private Integer id;
	private List<Track> tracks;
	private Map<String, Integer> ratings;
	
	public Playlist(Integer id) {
		this.id = id;
		this.tracks = new ArrayList<>();
		this.ratings = new HashMap<>();
	}

	public Integer getId() {
		return id;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Map<String, Integer> getRatings() {
		return ratings;
	}
	
	public void addTrack(Track faixa) {
		this.tracks.add(faixa);
	}
	
	public void putRating (String nomeUsuario, Integer avaliacao) {
		this.ratings.put(nomeUsuario, avaliacao);
	}
	
	public double averageRatings() {
		double soma = 0;
		for (Integer avaliacao: this.ratings.values()) {
			soma+=avaliacao;
		} 
		double media = soma/this.ratings.size();
		int inteira = (int) media;
		double fracionaria = media - inteira;
		
		if (fracionaria < 0.26) {
			return inteira;
		} else if (fracionaria >=0.26 && fracionaria < 0.74) {
			return inteira+0.5;
		}else {
			return inteira+1.0;
		}
		
	}
	

}
