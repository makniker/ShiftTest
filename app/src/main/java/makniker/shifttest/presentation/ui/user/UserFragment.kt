package makniker.shifttest.presentation.ui.user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.android.support.AndroidSupportInjection
import makniker.shifttest.core.ResponseStates
import makniker.shifttest.databinding.FragmentUserBinding
import makniker.shifttest.presentation.ui.UIStates
import javax.inject.Inject

class UserFragment : Fragment() {

    private val args: UserFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by
    createViewModelLazy(
        UserFragmentViewModel::class,
        { this.viewModelStore },
        factoryProducer = { viewModelFactory })
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.run {
        viewModel.getUserInfoById(args.Id)
        viewModel.userLiveData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResponseStates.Success -> {
                    flipper.displayedChild = UIStates.SUCCESS_VIEW.ordinal
                    bindData(result.data)
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

        val callback = requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(UserFragmentDirections.actionUserFragmentToUserListFragment())
        }
        callback.isEnabled=true

    }

    private fun bindData(result: UserModel) = binding.userLayout.run {
        Glide.with(preview).load(result.picture).into(preview)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}