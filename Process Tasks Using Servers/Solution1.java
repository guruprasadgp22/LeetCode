class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeServer = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        for (int i = 0; i < servers.length; i++) {
            freeServer.add(new int[] { servers[i], i });
        }

        PriorityQueue<int[]> busyServer = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }

                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int n = tasks.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!busyServer.isEmpty() && busyServer.peek()[0] == i) {
                int[] temp = busyServer.poll();
                freeServer.add(new int[] { temp[1], temp[2] });
            }

            if (freeServer.isEmpty()) {
                int[] temp = busyServer.poll();
                int finishTime = temp[0];
                int weight = temp[1];
                int index = temp[2];
                result[i] = index;
                busyServer.add(new int[]{finishTime + tasks[i], weight, index});
            } else {
                int[] temp = freeServer.poll();
                result[i] = temp[1];
                busyServer.add(new int[] { i + tasks[i], temp[0], temp[1] });
            }

        }
        return result;
    }
}
