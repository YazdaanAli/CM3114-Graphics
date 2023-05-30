package Objects;

public class SCone extends SObject{
    private float radius;
    private int slices;
    private float height;

    public SCone(){
        super();
        init();
        update();
    }

    public SCone(int height, float radius){
        super();
        init();
        this.radius = radius;
        this.height = height;
        update();
    }

    public SCone (float height, float radius, int slices){
        super();
        this.radius = radius;
        this.height = height;
        this.slices = slices;
        update();
    }

    public void init(){
        this.radius = 1;
        this.height = 2;
        this.slices = 40;
    }

    @Override
    protected void genData(){
        int j, k, i;
        double deltaLong = PI*2/slices;

        //Vertices coordinates, normal values and texture coordinates array

        numVertices = slices+3;
        vertices = new float[numVertices*3];
        normals = new float[numVertices*3];
        textures = new float[numVertices*2];

        //Cone tips generate Vertices coordinates, normal values and texture coordinates for top
        normals[0] = 0; normals[1] = 0; normals[2] = 1;
        vertices[0] = 0; vertices[1] = 0; vertices[2] = height;
        textures[0] = 0.5f; textures[1] = 1.0f;

        k=1;
        //vertices on the main body
        for(i = 0; i <= slices ; i++){
            normals[3*k] = cos(deltaLong*i);
            normals[3*k+1] =sin(deltaLong*i);
            normals[3*k+2] = 0;
            vertices[3*k] = radius*normals[3*k];
            vertices[3*k+1] = radius*normals[3*k+1];
            vertices[3*k+2] = -height/2; //Center point
            textures[2*k] = (float) i/slices;
            textures[2*k+1] = 0;
            k++;
        }


        //cone south pole
        normals[3*k] = 0; normals[3*k+1] = 0; normals[3*k+2] = -1;
        vertices[3*k] = 0; vertices[3*k+1] = 0; vertices[3*k+2] = -height/2;
        textures[2*k] = 0.5f; textures[2*k+1] = 0.0f; k++;

        numIndices = slices*6;
        indices = new int[numIndices];

        k = 0;
        //North Pole, numElement:slices*3
        for(j=1;j<=slices;j++){
            indices[k++] = 0;
            indices[k++] = j;
            indices[k++] = j+1;
        }

        //South Pole, numElement:slices*3
        int temp = numVertices-1;
        for(j=temp-1;j>temp-slices;j--){
            indices[k++] = temp;
            indices[k++] = j;
            indices[k++] = j-1;
        }


    }
    public void setRadius(float radius){
        this.radius = radius;
        updated = false;
    }

    public void setSlices(int slices){
        this.slices = slices;
        updated = false;
    }

    public void setHeight(float height){
        this.height = height;
        updated = false;
    }

    public float getRadius(){return radius;}

    public int getSlices(){return slices;}

    public float getHeight(){ return height; }

}

