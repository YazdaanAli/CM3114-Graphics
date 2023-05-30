package Objects;

public class SCube extends SObject {
    private float sides; //

    public SCube(){
        super();
        sides=12;
        update();
    }

    public SCube(float sides){
        super();
        this.sides = sides;
        update();
    }

    @Override
    protected void genData() {
        float hsl = sides/2; //hsl = half sides length

        numVertices = 24; // 6*4
        vertices = new float[]{
                //Back Face
                -hsl, hsl, -hsl, // Top Left of Square
                hsl, hsl, -hsl, // Top Right of square
                hsl, -hsl, -hsl, // Bottom Right of square
                -hsl, -hsl, -hsl, //Bottom Left of Square

                //Left Face
                -hsl, hsl, hsl, // Top Right of square
                -hsl, hsl, -hsl, // Top Left of square
                -hsl, -hsl, -hsl, // Bottom Left of square
                -hsl, -hsl, hsl, //Bottom Right of square

                //Top Face
                -hsl, hsl, hsl, // Bottom Left of square
                -hsl, hsl, -hsl, //Top Left of square
                hsl, hsl, -hsl, // Top Right of square
                hsl, hsl, hsl, //Bottom Right of square

                //Right Face
                hsl, hsl, hsl, // Top Left of square
                hsl, hsl, -hsl, // Top Right of square
                hsl, -hsl, -hsl, // Bottom Right of square
                hsl, -hsl, hsl, //Bottom Left of Square

                //Front Face
                -hsl, hsl, hsl, // Top Left of Square
                hsl, hsl, hsl, // Top Right of Square
                hsl, -hsl, hsl, // Bottom Right of Square
                -hsl, -hsl, hsl, //Bottom Left of Square

                //Bottom Face
                -hsl, -hsl, hsl, //Bottom Left of square
                -hsl, -hsl, -hsl, //Top Left of square
                hsl, -hsl, -hsl, //Top Right of square
                hsl, -hsl, hsl, //Bottom Right of square

        };

        normals = new float[]{
                //back
                0,0,-1,
                0,0,-1,
                0,0,-1,
                0,0,-1,
                //left
                -1,0,0,
                -1,0,0,
                -1,0,0,
                -1,0,0,
                //top face
                0,1,0,
                0,1,0,
                0,1,0,
                0,1,0,
                //right
                1,0,0,
                1,0,0,
                1,0,0,
                1,0,0,
                //front
                0,0,1,
                0,0,1,
                0,0,1,
                0,0,1,
                //bottom face
                0,-1,0,
                0,-1,0,
                0,-1,0,
                0,-1,0


        };

        textures = new float[]{
                //Back Face
                0,1,
                1,1,
                1,0,
                0,0,
                // Left face
                1,1,
                0,1,
                0,0,
                1,0,
                //Top face
                0,1,
                1,1,
                1,0,
                0,0,
                //Right face
                0,1,
                1,1,
                1,0,
                0,0,
                //Front Face
                1,1,
                0,1,
                0,0,
                1,0,
                //Bottom Face
                0,1,
                1,1,
                1,0,
                0,0

        };

        numIndices = 36; // 6*2*3
        indices = new int[]{
                //Back face //////
                2,0,1,
                2,3,0,
                //Left face //////
                6,7,4,
                6,4,5,
                //top face ////
                8,11,10,
                8,10,9,
                //right face
                15,14,13,
                15,13,12,
                //front face /////
                19,18,17,
                19,17,16,
                //bottom face ////
                23,21,22,
                23,20,21
        };

    }
    public void setSides (float sides) {
        this.sides = sides;
        updated = false;
    }

    public float getSides() { return sides; }


}
