package kr.co.tjoeun.listview_20200919.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.listview_20200919.R
import kr.co.tjoeun.listview_20200919.datas.Student
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId,mList) {

    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null){
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }
        val row = tempRow!!
//        row에 데이터를 반영해서 => return 되도록

        val stuendtId = row.findViewById<TextView>(R.id.stuendtId)
        val studentAge = row.findViewById<TextView>(R.id.studentAge)
        val studentAdress = row.findViewById<TextView>(R.id.studentAdress)

        val student = mList[position]
        stuendtId.text = student.name
        studentAdress.text = student.address

//        2020이 고정되면 => 해가 바뀌면 나이가 틀린 데이터.
//        2020을 현재 년도로 ? 지금 시간 기준

        val now = Calendar.getInstance() // 현재 일시가 now에 기록됨

        val koreanAge = now.get(Calendar.YEAR) - student.birthYear +1

        studentAge.text = "(${koreanAge}세)"


        return row

    }

}