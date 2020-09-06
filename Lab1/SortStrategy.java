/* CSCI-513: Lab-1
 * Team - Swathi Reddy Konatham (Z1864290)
 *        Ankita Ratnaparkhi (Z1907718)
 * ClassName - SortStrategy
 * Description - SortStrategy interface
 * */

public interface SortStrategy {
	public long[] sort(long[] numbers);
    public long getSortTime();
    public void resetTimer();
    public String strategyName();
}
