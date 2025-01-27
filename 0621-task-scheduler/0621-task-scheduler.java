class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // Step 2: Find the maximum frequency and the number of tasks with this frequency
        int maxFreq = 0;
        int numMaxFreqTasks = 0;
        for (int freq : frequencies) {
            if (freq > maxFreq) {
                maxFreq = freq;
                numMaxFreqTasks = 1;
            } else if (freq == maxFreq) {
                numMaxFreqTasks++;
            }
        }

        // Step 3: Calculate the minimum intervals
        int partCount = maxFreq - 1; // Number of partitions between maxFreq tasks
        int partLength = n - (numMaxFreqTasks - 1); // Remaining slots in each partition
        int emptySlots = partCount * partLength; // Total empty slots
        int remainingTasks = tasks.length - (maxFreq * numMaxFreqTasks); // Remaining tasks to fill slots
        int idles = Math.max(0, emptySlots - remainingTasks); // Remaining idle slots

        // Total intervals = tasks.length + idles
        return tasks.length + idles;
    }
}