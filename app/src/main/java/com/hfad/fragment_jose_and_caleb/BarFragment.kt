package com.hfad.fragment_jose_and_caleb

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.xy.BarFormatter
import com.androidplot.xy.BarRenderer
import com.androidplot.xy.BoundaryMode
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.StepMode
import com.androidplot.xy.XYPlot
import com.androidplot.xy.XYSeries

class BarFragment : Fragment() {
    private lateinit var plot: XYPlot

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the BarGraph view
        plot = view.findViewById(R.id.BarGraph)

        // Sample data (ensuring matching X & Y values)
        val domainLabels = listOf(1.0, 2.0, 3.0, 4.0)
        val series1Numbers = listOf(4.3, 2.5, 3.5, 4.5)
        val series2Numbers = listOf(2.4, 4.4, 1.8, 2.8)
        val series3Numbers = listOf(2.0, 2.0, 3.0, 5.0)

        // Convert to XYSeries
        val series1: XYSeries = SimpleXYSeries(domainLabels, series1Numbers, "Series1")
        val series2: XYSeries = SimpleXYSeries(domainLabels, series2Numbers, "Series2")
        val series3: XYSeries = SimpleXYSeries(domainLabels, series3Numbers, "Series3")

        // Apply default formatters and set colors
        val series1Format = BarFormatter().apply {
            fillPaint.color = Color.parseColor("#FF5722") // Color for series1
            borderPaint.color = Color.parseColor("#D84315") // Border color for series1
        }
        val series2Format = BarFormatter().apply {
            fillPaint.color = Color.parseColor("#3F51B5") // Color for series2
            borderPaint.color = Color.parseColor("#303F9F") // Border color for series2
        }
        val series3Format = BarFormatter().apply {
            fillPaint.color = Color.parseColor("#4CAF50") // Color for series3
            borderPaint.color = Color.parseColor("#2E7D32") // Border color for series3
        }

        // Add series to plot
        plot.addSeries(series1, series1Format)
        plot.addSeries(series2, series2Format)
        plot.addSeries(series3, series3Format)

        // Configure axis
        plot.setDomainBoundaries(0.5, 4.5, BoundaryMode.FIXED)
        plot.setRangeBoundaries(0, 6, BoundaryMode.FIXED)
        plot.setDomainStep(StepMode.INCREMENT_BY_VAL, 1.0)
        plot.setRangeStep(StepMode.INCREMENT_BY_VAL, 1.0)

        // Apply BarRenderer
        val renderer = plot.getRenderer(BarRenderer::class.java)
        renderer?.setBarGroupWidth(BarRenderer.BarGroupWidthMode.FIXED_WIDTH, 50f)

        // Refresh the graph
        plot.redraw()
    }
}
