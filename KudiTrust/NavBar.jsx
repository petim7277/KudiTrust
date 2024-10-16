import styles from "./Navbar.module.css";
import web_logo from "../../../assets/precious-logo.png";
import rectangle from "../../../assets/Rectangle.png";
import project_logo from "../../../assets/projects_logo.svg";
import heroPic from "../../../assets/heroPic.png";
import {Link, useNavigate} from "react-router-dom";
import styled from 'styled-components';

const PageWrapper = styled.div`
  background-image: url(${rectangle});
  background-size: cover;
  background-repeat: no-repeat;
  width: 100%;

`
const Navbar = () => {

    const navigate = useNavigate();

    const navLinks = [
        {link: '/', title: 'Home'},
        {link: '/skills', title: 'Skills'},
        {link: '/projects', title: 'Projects' , src:project_logo},
    ]


    return (
        <div style={{
            display: "grid",
            gridTemplateColumns: "40% 1fr",
        }}>
            <div>
                <img src={web_logo} alt="Logo" width="150px" height="40px"/>
            </div>
            <PageWrapper className={styles.mainDiv}>

                <div className={styles.navLinks}>
                    <div style={{
                        display: "flex",
                        alignItems: "center",
                        gap: '10px',
                    }}>
                        {
                            navLinks.map((link, index) => (
                                <Link key={index} to={link.link} style={{
                                    display: "flex",
                                    alignItems: "center",
                                    justifyContent: "center",
                                }}>
                                    {link?.src && <span><img src={link?.src} alt="Logo" width="50px"  height="30px"/></span>} {link.title}
                                </Link>
                            ))
                        }
                    </div>

                    <button className={styles.contactButton} onClick={()=> navigate("/contactMe")}>Contact me</button>
                </div>
                <img src={heroPic} alt="Logo" width="400px" height="550px"
                     style={{
                         paddingLeft: "100px",
                         marginTop: "50px",
                     }}
                />
            </PageWrapper>
        </div>

    )

}
export default Navbar;
