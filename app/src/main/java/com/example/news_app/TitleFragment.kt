package com.example.news_app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    private lateinit var binding : FragmentTitleBinding

    private val dataList= mutableListOf<NewsItem>(
            NewsItem("손흥민 '파워랭킹 1위' 올랐다…\"케인 이적 공백 지웠다\" 극찬까지","손흥민(토트넘)의 지난 주말 번리전 해트트릭(3골) 감동이 계속 이어지고 있다. 경기 공식 최우수선수부터 잉글랜드 프리미어리그(EPL) 주간 베스트11 싹쓸이, 유럽 5대리그 베스트11 선정에 이어 이번엔 파워랭킹 1위까지 깜짝 올랐다. 해리 케인(바이에른 뮌헨)의 이적 공백까지 메우고 있다는 극찬까지 더해져 의미를 더했다.\n" +
                    "\n" +
                    "영국 데일리메일이 6일(한국시간) 공개한 2023~24 EPL 파워랭킹에 따르면 손흥민은 단번에 1위에 이름을 올렸다. EPL 개막 3라운드까진 상위 10위 안에 이름을 올리지 못했지만, 지난 4라운드 번리전 해트트릭 효과로 톱10 진입은 물론 EPL 선수들 가운데 최상위에 이름을 올린 것이다. \n" +
                    "\n" +
                    "매체는 “토트넘은 케인의 이적으로 눈살을 찌푸릴 수밖에 없었지만, 손흥민이 그 고통스러운 이적 공백을 메우기에 충분해 보인다”며 “손흥민은 1~3라운드에선 골을 넣지 못했지만, 번리전에서 해트트릭을 기록하며 자신의 능력을 일깨웠다. 엔지 포스테코글루 감독 체제에서 강한 압박을 주도하고 있다. 필요할 때 날카로운 슈팅까지 선보이며 성공적인 경기를 치렀다”고 극찬했다. \n" +
                    "\n" +
                    "파워랭킹은 주간 베스트11처럼 지난 한 라운드 활약만 놓고 보는 게 아니라, 개막 후 활약이 누적돼 산정된다. 파워랭킹에 오른 선수들의 순위 등락이 표시되는 것도 같은 이유에서다. 개막 후 3경기째 공격 포인트가 없던 손흥민은 그동안 톱10에 포함될 정도까진 아니었다. 그러나 해트트릭을 터뜨린 번리전 단 한 경기 만으로 단숨에 현 시점 EPL 최고 선수로 우뚝 서게 된 것이다. \n" +
                    "\n" +
                    "지난 4라운드에서 해트트릭을 터뜨린 선수는 손흥민만이 아니었다. 에반 퍼거슨(브라이턴 앤 호브 알비온) 엘링 홀란(맨체스터 시티)도 나란히 같은 라운드에서 해트트릭을 기록했다. 다만 손흥민은 이들보다도 더 앞서 1위에 올랐다. 퍼거슨이 2위, 홀란이 3위로 그 뒤를 이었다. 손흥민처럼 퍼거슨과 홀란도 이번이 첫 파워랭킹 톱10 진입이다. 같은 해트트릭을 기록하고도 손흥민이 가장 높은 평가를 받았다. "),
            NewsItem("불에 뛰어든 소년..","기사내용없음"),
            NewsItem("일본 오염수 방류..","기사내용없음"),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTitleBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=Adapter(dataList)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())

        val articleFragment=ArticleFragment()

        adapter.itemClick=object : Adapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val bundle=Bundle()
                bundle.putString("title", dataList[position].title)
                bundle.putString("article", dataList[position].article)

                val fragmentManager=requireActivity().supportFragmentManager
                val transaction=fragmentManager.beginTransaction()
                transaction.addToBackStack(null)
                transaction.replace(R.id.frameLayout,articleFragment)
                articleFragment.arguments=bundle
                transaction.commit()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TitleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TitleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}