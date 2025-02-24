package com.hfad.fragment_jose_and_caleb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.xy.*


/**
 * A simple [Fragment] subclass.
 * Use the [LineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LineFragment : Fragment() {
    private lateinit var plot: XYPlot

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //initialize our XYPlot reference
        plot = view.findViewById(R.id.LineGraph)

        val domainLabels = arrayOf(1,2,3,4)
        val series1Numbers = arrayOf(4.3, 2.5, 3.5, 4.5)
        val series2Numbers = arrayOf(2.4, 4.4, 1.8, 2.8)
        val series3Numbers = arrayOf(2, 2, 3, 5)

        // turn the above arrays into XYSeries':
        val series1: XYSeries = SimpleXYSeries(
            listOf(*series1Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1"
        )
        val series2: XYSeries = SimpleXYSeries(
            listOf(*series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2"
        )
        val series3: XYSeries = SimpleXYSeries(
            listOf(*series3Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series3"
        )

        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        val series1Format = LineAndPointFormatter(requireContext(), R.xml.line_point_formatter_with_labels)
        val series2Format = LineAndPointFormatter(requireContext(), R.xml.line_point_formatter_with_labels_2)
        val series3Format = LineAndPointFormatter(requireContext(), R.xml.line_point_formatter_with_labels_3)

        plot.addSeries(series1, series1Format)
        plot.addSeries(series2, series2Format)
        plot.addSeries(series3, series3Format)


    }
}

