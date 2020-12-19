package m.latka.shoutbox

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_list.text = getLogin()
    }

    private fun getLogin():String {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref?.getString("KEY_LOGIN","").toString()
    }
}