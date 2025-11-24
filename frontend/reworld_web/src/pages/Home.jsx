import Header from "../components/Header.jsx";
import Banner from "../components/Banner.jsx";
import Section from "../components/Section.jsx";
import Footer from "../components/Footer.jsx";

export default function Home(){
    return (
        <>
            <Header />
            <main style={{margin: 0}}>
                <Banner />
                <Section
                    direction={"right"}
                    image={"https://cdn.hytale.com/5e7ba29d50cbcd001176c69b_84___ocean_3.jpg"}
                    gradientColor={"#003049"}
                    title={"Una nueva aventura te espera"}
                    text={"Explora un mundo enorme con misiones, gremios, personajes carismáticos, paisajes épicos y una gran personalización. Cada aventura es única, tú decides cómo vivirla."} />
                <Section
                    direction={"left"}
                    image={"https://cdn.hytale.com/5e7ba2b850cbcd001176c6a9_85___dungeon_portal.jpg"}
                    gradientColor={"#283618"}
                    title={"Eventos en vivo"}
                    text={"El mundo de ReWorld está en constante cambio. Por ello, cada cierto tiempo ocurren eventos increíbles que cambiarán la forma de jugar: todo ello desentrañando los misterios de este mundo."} />
                <Section
                    direction={"right"}
                    image={"https://cdn.hytale.com/5e7ba5083c9a2a00106793e4_134___roddan_castle.jpg"}
                    gradientColor={"#210f04"}
                    title={"Lánzate a la batalla"}
                    text={"¡Lucha junto a una facción por el control del mundo en el modo Guerra de Facciones! Expande tu terreno junto a tus aliados, forma estrategias y participa en batallones entre jugadores."} />
                <Section
                    direction={"left"}
                    image={"https://cdn.hytale.com/5e7ba4773c9a2a00106793a0_112___hypixel_lobby_2.jpg"}
                    gradientColor={"#240046"}
                    title={"Comunidad activa"}
                    text={"¡La comunidad de ReWorld es muy amigable! Allí podrás conocer gente para vivir tus aventuras, ofrecer sugerencias y estar atento a novedades y adelantos. ¿Te lo vas a perder?"} />

            </main>
            <Footer />
        </>
    )
}