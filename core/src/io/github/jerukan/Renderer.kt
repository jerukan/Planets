package io.github.jerukan

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import io.github.jerukan.planetdata.Planets
import io.github.jerukan.util.CameraWrapper
import io.github.jerukan.util.Utils
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch


class Renderer {
    companion object {
        var shapeRenderer: ShapeRenderer = ShapeRenderer()
        var camera: OrthographicCamera = OrthographicCamera(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        var camwrapper: CameraWrapper = CameraWrapper(camera)
//        var originx: Float = Gdx.graphics.width.toFloat() / 2f
//        var originy: Float = Gdx.graphics.height.toFloat() / 2f
        var originx: Float = 0f
        var originy: Float = 0f

        var font = BitmapFont()

        fun init() {
            camwrapper.init()
        }

        fun render(batch: SpriteBatch) {
            shapeRenderer.projectionMatrix.set(camwrapper.camera.combined)
            shapeRenderer.updateMatrices()

            shapeRenderer.setAutoShapeType(true)
            Gdx.gl20.glEnable(GL20.GL_BLEND)
            Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
            shapeRenderer.setColor(1f, 1f, 1f, 1f)
            for(planet in Planets.planetlist) {
                shapeRenderer.ellipse(planet.orbit.ellipse.x, planet.orbit.ellipse.y, planet.orbit.ellipse.width, planet.orbit.ellipse.height)
            }
            shapeRenderer.end()

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
            shapeRenderer.circle(SolarSystem.SolarSystem.sunpos.x - Utils.sun_draw_radius, SolarSystem.SolarSystem.sunpos.y - Utils.sun_draw_radius, Utils.sun_draw_radius)
            batch.begin()
            for(planet in Planets.planetlist) {
                shapeRenderer.circle(planet.screen_pos.x, planet.screen_pos.y, planet.radius_drawn.toFloat())
                font.draw(batch, planet.name, planet.screen_pos.x + planet.radius_drawn.toFloat(), planet.screen_pos.y + planet.radius_drawn.toFloat())
            }
            batch.end()
            shapeRenderer.end()
            Gdx.gl20.glDisable(GL20.GL_BLEND)
        }
    }
}