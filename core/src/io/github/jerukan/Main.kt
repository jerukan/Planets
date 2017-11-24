package io.github.jerukan

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import io.github.jerukan.planetdata.Planet

class Main : Game() {
    lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()
    }

    override fun render() {
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
