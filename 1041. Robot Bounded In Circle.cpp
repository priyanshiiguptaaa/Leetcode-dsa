class Solution {
public:
    bool isRobotBounded(string instructions) {
        int n = instructions.length();
        int deg = 0;        
        int x = 0, y = 0;   

        for (int i = 0; i < n; i++) {
            if (instructions[i] == 'L') {
                deg -= 90;
            } 
            else if (instructions[i] == 'R') {
                deg += 90;
            } 
            else {
                int d = ((deg % 360) + 360) % 360;
                if (d == 0) y++;
                else if (d == 90) x++;
                else if (d == 180) y--;
                else if (d == 270) x--;
            }
        }

        deg = ((deg % 360) + 360) % 360;

        return (x == 0 && y == 0) || deg != 0;
    }
};
