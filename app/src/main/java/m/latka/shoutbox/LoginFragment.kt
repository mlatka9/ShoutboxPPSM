package m.latka.shoutbox

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextLogin.setText(getLogin())

        buttonSetLogin.setOnClickListener { view ->
            if(!(editTextLogin.text.toString().isNullOrBlank())){
                putLogin(editTextLogin.text.toString())
                view.findNavController().navigate(R.id.action_nav_home_to_nav_gallery)
            } else {
                Snackbar.make(view, "Login is required", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }

    private fun putLogin(login: String) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString("KEY_LOGIN", login)
            apply()
        }
    }

    private fun getLogin():String {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        return sharedPref?.getString("KEY_LOGIN","").toString()
    }
}