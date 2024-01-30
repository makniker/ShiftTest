package makniker.shifttest.presentation.ui.user

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.android.support.AndroidSupportInjection
import makniker.shifttest.R
import makniker.shifttest.core.ResponseStates
import makniker.shifttest.databinding.FragmentUserBinding
import makniker.shifttest.presentation.ui.UIStates
import javax.inject.Inject


class UserFragment : Fragment() {

    private val args: UserFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by createViewModelLazy(UserFragmentViewModel::class,
        { this.viewModelStore },
        factoryProducer = { viewModelFactory })
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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
            parentFragmentManager.popBackStack()
        }
        callback.isEnabled = true

    }

    private fun bindData(result: UserModel) = binding.userLayout.run {
        Glide.with(preview).load(result.picture).into(preview)
        name.text = result.name
        location.text = result.location
        phone.text = result.phone
        map.text = context?.getString(
            R.string.coordinates, result.coordinates.latitude, result.coordinates.longitude
        ) ?: ""
        email.text = result.email

        phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${result.phone}")
            startActivity(intent)
        }
        map.setOnClickListener {
            val location =
                Uri.parse("geo:${result.coordinates.latitude},${result.coordinates.longitude}")
            val mapIntent = Intent(Intent.ACTION_VIEW, location)
            startActivity(mapIntent)
        }
        email.setOnClickListener {
            val emailText =
                Uri.parse("mailto:" + result.email)
            val emailIntent = Intent(Intent.ACTION_VIEW, emailText)
            startActivity(emailIntent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}