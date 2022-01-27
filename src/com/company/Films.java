package com.company;

public class Films {

    int ticketPrise;
    String nameOfFilm, genreOfFilm;

    public Films(String nameOfFilm, int ticketPrise, String genreOfFilm) {
        this.ticketPrise = ticketPrise;
        this.genreOfFilm = genreOfFilm;
        this.nameOfFilm = nameOfFilm;
    }

    public int getTicketPrise() {
        return ticketPrise;
    }

    public void setTicketPrise(int ticketPrise) {
        this.ticketPrise = ticketPrise;
    }

    public String getNameOfFilm() {
        return nameOfFilm;
    }

    public void setNameOfFilm(String nameOfFilm) {
        this.nameOfFilm = nameOfFilm;
    }

    public String getGenreOfFilm() {
        return genreOfFilm;
    }

    public void setGenreOfFilm(String genreOfFilm) {
        this.genreOfFilm = genreOfFilm;
    }
}