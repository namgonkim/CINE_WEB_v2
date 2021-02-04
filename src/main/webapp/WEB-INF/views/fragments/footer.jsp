<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
   <!-- FOOTER 1 -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-3 ">
                    <div>
                        <a href="index.html">
                            <img class="footer-logo" src="/img/logo-footer.png" alt="logo">
                        </a>
                    </div>
                    <div>
                        <address class="margin-bottom-30">
                            <p> 참빛관 613호 <br/>
                            34117 Kassel<br/>
                            Germany</p>
                        </address>
                    </div>
                    <div class="margin-bottom-30">
                        <p><i class="fa fa-phone"></i> +82-2-940-5127
                            <br/>
                            <i class="fa fa-fax"></i> +49 561 00 00 00 00</p>
                    </div>
                    <div>
                        <a href="https://www.kw.ac.kr">광운대학교</a>
                        <br/>
                        <a href="https://www.mclab.kw.ac.kr">(구)연구실 홈페이지</a>
                    </div>
                </div>
                <div class="col-md-3 footer-blog">
                    <h4>          </h4>
                    <ul>
                        <li><a href="#">    <br/></a> <a href="#">     </a></li>
                        <li><a href="#">    <br/></a> <a href="#">     </a></li>
                        <li><a href="#">    <br/></a> <a href="#">     </a></li>
                        <li><a href="#">    <br/></a> <a href="#">     </a></li>
                    </ul>
                </div>
                <div class="col-md-3 footer-menu">
                    <h4>BUG REPORT</h4>
                    <p>아래의 메일로 문의 주세요.</p>
                    <a>zxcv9455@naver.com</a>
                    
                </div>
                <div class="col-md-3  footer-menu">
                    <h4>ADMIN</h4>
                    <ul>
                    	<sec:authorize access="isAnonymous()">
	                        <li><a href="/user/login">Admin Login</a></li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                        <a href="/user/logout">
                            <li>Logout</li>
                        </a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="/admin">
                            <li>Admin Page</li>
                        </a>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous()">
                        <a href="/user/signup">
                            <li>Sign Up</li>
                        </a>
                        </sec:authorize>
                    </ul>
                </div>

            </div>
        </div>
    </footer>

    <script src="/assets/libs/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="/assets/libs/popper.js/dist/umd/popper.min.js"></script>
    <script src="/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="/assets/extra-libs/sparkline/sparkline.js"></script>
    <!--Wave Effects -->
    <script src="/dist/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="/dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="/dist/js/custom.min.js"></script>
    <!-- this page js -->
    <script src="/assets/extra-libs/multicheck/datatable-checkbox-init.js"></script>
    <script src="/assets/extra-libs/multicheck/jquery.multicheck.js"></script>
    <script src="/assets/extra-libs/DataTables/datatables.min.js"></script>
    <script>
        /****************************************
         *       Basic Table                   *
         ****************************************/
        $('#zero_config').DataTable();
    </script>

    <!-- Scripts -->
    <!-- Loads Bootstrap Main JS -->
    <!-- <script src="/bootstrap/js/bootstrap.min.js"></script>  -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/bootstrap/js/ie10-viewport-bug-workaround.js"></script>

    <!-- Initiate Google Maps - For more Infos look into the documentation -->
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <script src="/js/google-map.js"></script>

    <!-- Initiate Portoflio Script -->
    <script src="/extensions/portfolio/isotope.min.js"></script>
    <script src="/extensions/portfolio/portfolio.js"></script>

    <!-- Initiate Fancybox/Lightbox Script -->
    <!-- Fancybox/Lightbox -->
    <script type="text/javascript" src="/extensions/fancybox/jquery.fancybox.js"></script>
    <script type="text/javascript" src="/extensions/fancybox/jquery.fancybox.pack.js"></script>
    <link rel="stylesheet" type="text/css" href="/extensions/fancybox/jquery.fancybox.css" media="screen" />
    <script type="text/javascript" src="/extensions/fancybox/jquery.fancybox-media.js"></script>
    <!-- Initiate Fancybox/Lightbox for Videos -->
    <script type="text/javascript">
        $(document).ready(function () {
            /*
             *  Media helper. Group items, disable animations, hide arrows, enable media and button helpers.
             */
            $('.fancybox-media')
                .attr('rel', 'media-gallery')
                .fancybox({
                    openEffect: 'none',
                    closeEffect: 'none',
                    prevEffect: 'none',
                    nextEffect: 'none',
                    arrows: false,
                    helpers: {
                        media: {},
                        buttons: {}
                    }
                });
        });
    </script>