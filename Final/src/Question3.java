import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question3 {
	
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
	      List<Callable<Integer>> tasks = new ArrayList<>();
	      for (String filename : args)
	      {
	         tasks.add(wordCount(filename, 4));
	      }
	      List<Future<Integer>> resultFutures = service.invokeAll(tasks);
	      int[] totals = new int[resultFutures.size()];
	      int i = 0;
	      int totalCount = 0;
	      for (Future<Integer> resultFuture : resultFutures)
	      {
	         totals[i] += resultFuture.get();
	         totalCount+= resultFuture.get();
	         i++;
	      }

	      for(int j = 0; j < totals.length; j++){
	        System.out.println(args[j] + ": " + totals[j]);
	      }

	      service.shutdown();
	      System.out.println("Total Count of Words: "+ totalCount);
	   }
 
	
	public static Callable<Integer> wordCount(String filename, int length) {
		return () -> 
        {
        	List<String> lines = Files.readAllLines(Paths.get(filename));
            int count = 0;
            for (String line : lines)
            {
               String[] words = line.split("[\\PL]+");
               for (String word : words)
                  if (word.length() >= length) 
                	  count++;
            }

            return count;
        };
      }
	
}
