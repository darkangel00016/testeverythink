package everithink.test

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import everithink.test.Listeners.OnItemUserClick
import everithink.test.models.User
import everithink.test.modules.details.UserFragment
import everithink.test.presenter.MainImpl
import everithink.test.view.Main
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment(), Main, OnItemUserClick {

    lateinit var presenter: MainImpl
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: everithink.test.Adapters.User
    private lateinit var viewManager: RecyclerView.LayoutManager

    companion object {
        fun instance(): MainActivityFragment {
            return MainActivityFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.setTitle(getString(R.string.title_activity_main))
        presenter = MainImpl(this)
        viewManager = LinearLayoutManager(this.activity)
        viewAdapter = everithink.test.Adapters.User(ArrayList(), this)
        recyclerView = view?.findViewById<RecyclerView>(R.id.listUsers).apply {
            this?.setHasFixedSize(true)
            this?.layoutManager = viewManager
            this?.adapter = viewAdapter
            this?.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }!!
        presenter.getUsers()
    }

    override fun onResume() {
        super.onResume()
        val main = activity as MainActivity
        main.desactiveBack()
    }

    override fun onGetUsers(users: ArrayList<User>) {
        viewAdapter.setItems(users)
    }

    override fun onItemClicked(user: User) {
        val main = activity as MainActivity
        main.replaceFragment(UserFragment.instance(user))
    }

    override fun showError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        activity?.runOnUiThread {
            if (progress != null) {
                progress.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
        }
    }

    override fun hideProgress() {
        activity?.runOnUiThread {
            if (progress != null) {
                progress.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }
        }
    }
}
