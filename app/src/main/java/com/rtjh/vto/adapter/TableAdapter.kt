package com.rtjh.vto.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.bin.david.form.core.SmartTable
import com.bin.david.form.data.column.Column
import com.bin.david.form.data.format.bg.IBackgroundFormat
import com.bin.david.form.data.format.grid.IGridFormat
import com.bin.david.form.data.style.FontStyle
import com.bin.david.form.data.style.LineStyle
import com.bin.david.form.data.table.TableData
import com.rtjh.vto.R
import com.rtjh.vto.model.SchedulingInfoDataModel

class TableAdapter(private val context : Context) {
    @SuppressLint("ResourceAsColor")
    fun setupTable(smartTable : SmartTable<SchedulingInfoDataModel>) {
        // 创建列
        val surgeryNameColumn = Column<String>("手术名称", "surgeryName")
        val patientColumn = Column<String>("患者", "patient")
        val surgeonColumn = Column<String>("主刀医生", "surgeon")
        val nurseColumn = Column<String>("责任护士", "nurse")
        val surgeryTimeColumn = Column<String>("手术时间", "surgeryTime")
        val surgeryStatusColumn = Column<String>("手术状态", "surgeryStatus")

        // 设置表格数据
        val dataList : List<SchedulingInfoDataModel> = listOf(
            SchedulingInfoDataModel("手术1", "患者A", "医生1", "护士1", "2023-01-01", "手术中"),
            SchedulingInfoDataModel("手术2", "患者B", "医生2", "护士2", "2023-01-01", "手术中"),
            SchedulingInfoDataModel("手术3", "患者C", "医生1", "护士3", "2023-01-01", "手术中"),
            SchedulingInfoDataModel("手术4", "患者D", "医生2", "护士3", "2023-01-01", "手术中"),
            SchedulingInfoDataModel("手术5", "患者E", "医生1", "护士2", "2023-01-01", "手术中"),
            SchedulingInfoDataModel("手术6", "患者F", "医生2", "护士1", "2023-01-01", "手术中"),
            SchedulingInfoDataModel("手术7", "患者F", "医生2", "护士1", "2023-01-01", "手术中"),
        )

        // 设置表格数据
        val tableData = TableData(
            "",
            dataList,
            surgeryNameColumn,
            patientColumn,
            surgeonColumn,
            nurseColumn,
            surgeryTimeColumn,
            surgeryStatusColumn
        )
        val config = smartTable.config
        config.isShowTableTitle = false
        config.isShowXSequence = false
        config.isShowYSequence = false
        config.columnTitleStyle = FontStyle().setTextSize(24)
            .setTextColor(R.color.black)
        config.columnTitleBackground = IBackgroundFormat{canvas, rect, paint ->
            paint.color = ContextCompat.getColor(context, R.color.table_title_bg_color)
            canvas.drawRect(rect, paint)
        }
        config.contentStyle = FontStyle().setTextSize(24)
            .setTextColor(R.color.black)
        config.contentBackground = IBackgroundFormat{canvas, rect, paint ->
            paint.color = ContextCompat.getColor(context, R.color.table_content_bg_color)
            canvas.drawRect(rect, paint)
        }
        LineStyle.setDefaultLineColor(Color.parseColor("#FFFFFF"))
        LineStyle.setDefaultLineSize(0.toFloat())
        smartTable.tableData = tableData
    }
}