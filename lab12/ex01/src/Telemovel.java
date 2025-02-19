public class Telemovel {
    private String processador;
    private Double preco;
    private Integer memoria;
    private String camera;

    private Telemovel(String processador, Double preco, Integer memoria, String camera) {
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camera = camera;
    }

    public static Telemovel creaTelemovel(String processador, Double preco, Integer memoria, String camera) {
        return new Telemovel(processador, preco, memoria, camera);
    }

    public String getProcessador() {
        return processador;
    }
    public void setProcessador(String processador) {
        this.processador = processador;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Integer getMemoria() {
        return memoria;
    }
    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }
    public String getCamera() {
        return camera;
    }
    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return "Processador: " + processador + "\nPreço: " + preco + "€\nMemória: " + memoria + "GB\nCâmera: " + camera;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Telemovel other = (Telemovel) obj;
        if (camera == null) {
            if (other.camera != null) {
                return false;
            }
        } else if (!camera.equals(other.camera)) {
            return false;
        }
        if (memoria == null) {
            if (other.memoria != null) {
                return false;
            }
        } else if (!memoria.equals(other.memoria)) {
            return false;
        }
        if (preco == null) {
            if (other.preco != null) {
                return false;
            }
        } else if (!preco.equals(other.preco)) {
            return false;
        }
        if (processador == null) {
            if (other.processador != null) {
                return false;
            }
        } else if (!processador.equals(other.processador)) {
            return false;
        }
        return true;
    }

    public int compareTo(Telemovel other, String key) {
        if (key.equals("preco")) {
            return preco.compareTo(other.getPreco());
        } else if (key.equals("memoria")) {
            return memoria.compareTo(other.getMemoria());
        } else if (key.equals("camera")) {
            return Integer.parseInt(camera.split("MP")[0]) - Integer.parseInt(other.getCamera().split("MP")[0]);
        } else if (key.equals("processador")) {
            return processador.compareTo(other.getProcessador());
        } else {
            return 0;
        }
    }

}
