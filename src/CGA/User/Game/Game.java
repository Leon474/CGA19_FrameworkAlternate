package CGA.User.Game;

/**
 * Created by Fabian on 16.09.2017.
 */
import CGA.Framework.*;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

import static org.lwjgl.glfw.GLFW.*;

public class Game extends GameWindow
{
    private Scene scene;

    public Game(int width,
                int height,
                boolean fullscreen,
                boolean vsync,
                String title,
                int GLVersionMajor,
                int GLVersionMinor)
    {
        super(width, height, fullscreen, vsync, GLVersionMajor, GLVersionMinor, title, 4, 120.0f);
        scene = new Scene(this);
    }

    @Override
    protected void init()
    {
        setCursorVisible(false);
        if(!scene.init())
            quit();
    }

    @Override
    protected void shutdown() {
        scene.cleanup();
    }

    @Override
    protected void update(float dt, float t)
    {
        scene.update(dt, t);
    }

    @Override
    protected void render(float dt, float t)
    {
        scene.render(dt, t);
    }

    @Override
    protected void onMouseMove(double xpos, double ypos) {
        scene.onMouseMove(xpos, ypos);
    }

    @Override
    protected void onKey(int key, int scancode, int action, int mode) {
       scene.onKey(key, scancode, action, mode);
    }


}
