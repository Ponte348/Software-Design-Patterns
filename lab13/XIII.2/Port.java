public interface Port extends Iterable<String> {
	public boolean add(String ref, Ship p);
	public boolean exists(String ref);
	public Ship remove(String ref);
}
