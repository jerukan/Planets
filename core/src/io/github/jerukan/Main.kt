package io.github.jerukan

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.jerukan.planetdata.Planet
import io.github.jerukan.util.Input
import io.github.jerukan.util.Utils

class Main : Game() {
    lateinit var batch: SpriteBatch
    var time: Double = 0.0

    override fun create() {
        Renderer.init()
        Gdx.input.inputProcessor = Input()
        batch = SpriteBatch()
    }

    override fun render() {
        time += Utils.t_step
        Renderer.camwrapper.update()
        batch.projectionMatrix.set(Renderer.camwrapper.camera.combined)
        SolarSystem.SolarSystem.updatePositions(time)
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        Renderer.render()
        batch.begin()
        batch.end()
    }

    override fun resize(width: Int, height: Int) {

    }

    override fun dispose() {
        batch.dispose()
    }
}
