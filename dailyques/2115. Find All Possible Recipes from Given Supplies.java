//solved using topological sorting in graphs 
// O(R+I)

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); // Ingredient -> Recipes that need it
        Map<String, Integer> inDegree = new HashMap<>();   // Recipe -> Missing ingredient count

        // Initialize the graph
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size()); // Missing ingredients count
            
            for (String ing : ingredients.get(i)) {
                graph.computeIfAbsent(ing, k -> new ArrayList<>()).add(recipe);
            }
        }

        // Add initial supplies to queue
        Queue<String> queue = new LinkedList<>();
        Set<String> possibleRecipes = new HashSet<>(Arrays.asList(supplies));

        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (inDegree.containsKey(item)) { // If item is a recipe, add to result
                result.add(item);
            }

            // Reduce in-degree of dependent recipes
            if (graph.containsKey(item)) {
                for (String recipe : graph.get(item)) {
                    inDegree.put(recipe, inDegree.get(recipe) - 1);
                    if (inDegree.get(recipe) == 0) { // If all ingredients available
                        queue.offer(recipe);
                        possibleRecipes.add(recipe);
                    }
                }
            }
        }

        return result;
    }
    }
