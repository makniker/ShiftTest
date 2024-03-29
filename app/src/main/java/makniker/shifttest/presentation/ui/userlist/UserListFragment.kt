package makniker.shifttest.presentation.ui.userlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.AndroidSupportInjection
import makniker.shifttest.core.ResponseStates
import makniker.shifttest.databinding.FragmentUserListBinding
import makniker.shifttest.presentation.ui.UIStates
import javax.inject.Inject

class UserListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by createViewModelLazy(UserListViewModel::class,
        { this.viewModelStore },
        factoryProducer = { viewModelFactory })

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.run {
        userList.addItemDecoration(
            DividerItemDecoration(
                requireContext(), RecyclerView.VERTICAL
            )
        )
        val userListAdapter = UserListAdapter {
            val action = UserListFragmentDirections.actionUserListFragmentToUserFragment2(it.id)
            findNavController().navigate(action)
        }
        viewModel.fetchCatalog()
        viewModel.userListLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseStates.Success -> {
                    flipper.displayedChild = UIStates.SUCCESS_VIEW.ordinal
                    userListAdapter.submitList(result.data)
                }

                is ResponseStates.Failure -> {
                    flipper.displayedChild = UIStates.FAILURE_VIEW.ordinal
                    errorLayout.error.text = result.e.message
                }

                is ResponseStates.Loading -> {
                    flipper.displayedChild = UIStates.LOADING_VIEW.ordinal
                }
            }
        }
        userList.adapter = userListAdapter
        fab.setOnClickListener {
            viewModel.updateCatalog()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}