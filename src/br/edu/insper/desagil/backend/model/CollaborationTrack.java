package br.edu.insper.desagil.backend.model;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTrack extends Track{
	private List<Artist> collaborators;

	public CollaborationTrack(Artist artist, List<Artist> collaborators, String name, Integer duration) {
		super(artist, name, duration);
		this.collaborators = collaborators;
	}
	
	@Override
	public String getFullArtistName() {
		String nome = getArtist().getName()+" (feat.";
		List<String>termos = new ArrayList<>();
		for (Artist artista: this.collaborators) {
			termos.add(" "+ artista.getName());
		}
		return nome+String.join(",", termos)+")";
	}
	
}
