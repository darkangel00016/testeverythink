package everithink.test.modules.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import everithink.test.MainActivity
import everithink.test.R
import everithink.test.models.User
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment() {

    companion object {

        fun instance(user: User): UserFragment {
            val fragment = UserFragment()
            val bundle = Bundle()
            bundle.putParcelable("USER", user)
            fragment.arguments = bundle
            return fragment
        }

    }

    var user: User? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arguments = getArguments()
        if (arguments?.get("USER") != null) {
            user = arguments.getParcelable("USER")
            activity?.setTitle(user?.name?.getName())
            name.text = user?.name?.getName()
            email.text = user?.email
            phone.text = user?.phone
            cellphone.text = user?.cell
            birthday.text = user?.dob?.date
            address.text = user?.location?.getAddress()
            Picasso.get().load(user?.picture?.large).into(imgProfile)
        }
    }

    override fun onResume() {
        super.onResume()
        val main = activity as MainActivity
        main.activeBack()
    }

}
