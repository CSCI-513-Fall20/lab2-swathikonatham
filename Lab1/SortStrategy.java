
public interface SortStrategy {
	public long[] sort(long[] numbers);
    public long getSortTime();
    public void resetTimer();
    public String strategyName();
}
