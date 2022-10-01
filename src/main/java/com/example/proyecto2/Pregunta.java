package com.example.proyecto2;

public class Pregunta {
    public static int numero=1;
    private int correlativo;
    private String pregunta;
    private String tiempoLimite;
    private String respuesta;
    private String punteo;

    public Pregunta(String pregunta, String tiempoLimite, String respuesta, String punteo) {
        this.correlativo= numero;
        this.pregunta = pregunta;
        this.tiempoLimite = tiempoLimite;
        this.respuesta = respuesta;
        this.punteo = punteo;
        numero++;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTiempoLimite() {
        return tiempoLimite;
    }

    public void setTiempoLimite(String tiempoLimite) {
        this.tiempoLimite = tiempoLimite;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getPunteo() {
        return punteo;
    }

    public void setPunteo(String punteo) {
        this.punteo = punteo;
    }
}
