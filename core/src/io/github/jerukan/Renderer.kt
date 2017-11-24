package io.github.jerukan

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import io.github.jerukan.planetdata.Planets

class Renderer {
    companion object {
        var shapeRenderer: ShapeRenderer = ShapeRenderer()
        var camera: OrthographicCamera = OrthographicCamera(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        var originx: Float = Gdx.graphics.width.toFloat() / 2f
        var originy: Float = Gdx.graphics.height.toFloat() / 2f
        fun render() {
            shapeRenderer.setAutoShapeType(true)
            Gdx.gl20.glEnable(GL20.GL_BLEND)
            Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
            shapeRenderer.begin()
            shapeRenderer.set(ShapeRenderer.ShapeType.Line)
            shapeRenderer.setColor(1f, 1f, 1f, 1f)
            shapeRenderer.ellipse(Planets.mercury.orbit.ellipse.x, Planets.mercury.orbit.ellipse.y, Planets.mercury.orbit.ellipse.width, Planets.mercury.orbit.ellipse.height)
            shapeRenderer.end()
            Gdx.gl20.glDisable(GL20.GL_BLEND)
        }
    }
}