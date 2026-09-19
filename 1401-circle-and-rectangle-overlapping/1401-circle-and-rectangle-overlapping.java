class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest point on the rectangle to the circle's centre
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Compute squared distance between the centre and that point
        long dx = closestX - (long) xCenter;
        long dy = closestY - (long) yCenter;
        long distSq = dx * dx + dy * dy;

        // Compare with radius squared
        long radiusSq = (long) radius * radius;
        return distSq <= radiusSq;
    }
}