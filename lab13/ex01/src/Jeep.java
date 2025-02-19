public class Jeep implements Product{
    private String data;
    private String code;
    private String description;
    private double points;
    private ProductState state = new AvailableState();

	public Jeep(OldJeep oldie) {
		String[] dados = oldie.getData().split(";");
        code = dados[0];
        description = dados[1];
        points = Double.parseDouble(dados[2]);
	}
	
	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Jeep [data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jeep other = (Jeep) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double points() {
        return points;
    }

    @Override
    public void setState(ProductState estado) {
        state = estado;
    }

    @Override
    public boolean nextState() {
        state.nextState(this);
        return true;
    }

    @Override
    public boolean equals(Product p) {
        if(this.code.equals(p.code()) &&
            this.description.equals(p.description()) &&
                this.points == p.points())
            return true;
        return false;
    }
}
